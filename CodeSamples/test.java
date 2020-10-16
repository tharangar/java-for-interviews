
public class test {

public GetUserAccountInfoResponseSet getUserAccountInfo(String userID, AccountTypeEnum accountType, 
String accountNumber, String accountName, String acctOpenedDateFrom, String acctOpenedDateTo,
String currencyType) {
logger.info("================== Start getUserAccountInfo request =================");
Set<GetUserAccountInfoResponse> getUserAccountInfoResponseSet = new HashSet<GetUserAccountInfoResponse>();

GetUserAccountInfoResponseSet getUserAccountInfoResponse = new GetUserAccountInfoResponseSet();


CommonResponse commonResponse = new CommonResponse();

List<CompanyAccountMst> companyAccountMst = companyAccountsFilterRepository.findCompanyAccounts(userID,
accountType, accountNumber, accountName, acctOpenedDateFrom, acctOpenedDateTo, currencyType);

if (!companyAccountMst.isEmpty()) {

companyAccountMst.forEach(companyAccountMstList -> {
getUserAccountInfoResponseSet.add(getDetailsByAccountNumber(accountNumber));
getUserAccountInfoResponse.setGetUserAccountInfo(getUserAccountInfoResponseSet);
});
getUserAccountInfoResponse.setReturnCode(HttpStatus.OK.value());
getUserAccountInfoResponse.setErrorCode(ErrorCode.OPARATION_SUCCESS);
getUserAccountInfoResponse.setReturnMessage(messageSource.getMessage(ErrorCode.OPARATION_SUCCESS,
new Object[] { ErrorDescription.SUCCESS }, LocaleContextHolder.getLocale()));

} else {
logger.info(messageSource.getMessage(ErrorCode.NO_RECORD_FOUND, null, LocaleContextHolder.getLocale()));
commonResponse.setErrorCode(ErrorCode.NO_RECORD_FOUND);
commonResponse.setReturnCode(HttpStatus.OK.value());
commonResponse.setReturnMessage(
messageSource.getMessage(ErrorCode.NO_RECORD_FOUND, null, LocaleContextHolder.getLocale()));

}
logger.info("================== End getUserAccountInfo request =================");
return getUserAccountInfoResponse;

}

private GetUserAccountInfoResponse getDetailsByAccountNumber(String accountNumber) {
logger.info("================== Start get getDetailsByAccountNumber =================");
GetUserAccountInfoResponse getUserAccountInfoResponse = new GetUserAccountInfoResponse();

Set<PrimaryCompanyAcc> primaryCompmanyAccSet = new HashSet<PrimaryCompanyAcc>();
PrimaryCompanyAcc primaryCompanyAcc = new PrimaryCompanyAcc();

Set<LinkedCompBean> linkedCompBeanSet = new HashSet<LinkedCompBean>();
LinkedCompBean linkedCompBean = new LinkedCompBean();
Set<UserComAccount> userCompAccountSet = new HashSet<UserComAccount>();
UserComAccount userComAccount = new UserComAccount();
//Get UserPrimaryAccount Table
Optional<UserPrimaryAccount> userPrimaryAccount = userPrimaryAccountRepository.findByAccountNo(accountNumber);
primaryCompanyAcc.setAccountNumber(userPrimaryAccount.get().getAccountNo());

//Get CompanyAccountMst Table
Optional<CompanyAccountMst> companyAccount = companyAccountRepository
.findByAccountNo(userPrimaryAccount.get().getAccountNo());
primaryCompanyAcc.setAccountName(companyAccount.get().getAccountName());
primaryCompanyAcc.setAccountType(companyAccount.get().getAccountType());
primaryCompanyAcc.setAllAcctAccessFlg(userPrimaryAccount.get().getUserMstAcc().getAllAcctAccessFlg());
//Get UserLinkedCompany Table
Optional<UserLinkedCompany> userlinkedcompany = userLinkCompanyRepository
.findByCompanyMst(companyAccount.get().getCompanyId());
linkedCompBean.setCompanyId(userlinkedcompany.get().getCompanyMst().getCompanyId());
linkedCompBean.setAllAcctAccessFlg(userlinkedcompany.get().getAllAcctAccessFlg());
//Get CompanyMst Table
Optional<CompanyMst> companyMst = companyMstRepository.findByCompanyId(userlinkedcompany.get().getCompanyMst().getCompanyId());
linkedCompBean.setCompanyName(companyMst.get().getCompanyName());
//Get UserCompanyAccount Table
Optional<UserCompanyAccount> userCompanyAccount = userCompanyAccountRepository.findByAccountNo(accountNumber);
userComAccount.setAccountNumber(userCompanyAccount.get().getAccountNo());

Optional<CompanyAccountMst> companyAccountmst = companyAccountRepository
.findByAccountNo(userCompanyAccount.get().getAccountNo());
userComAccount.setAccountName(companyAccountmst.get().getAccountName());
userComAccount.setAccountType(companyAccountmst.get().getAccountType());

userCompAccountSet.add(userComAccount);
linkedCompBean.setUserCompAccounts(userCompAccountSet);
linkedCompBeanSet.add(linkedCompBean);
primaryCompmanyAccSet.add(primaryCompanyAcc);
getUserAccountInfoResponse.setPrimaryCompmanyAcc(primaryCompmanyAccSet);
getUserAccountInfoResponse.setLinkedcompbean(linkedCompBeanSet);
logger.info("================== End get getDetailsByAccountNumber =================");
return getUserAccountInfoResponse;

}


}
