
# WORKFLOW ESB PROJECT

Workflow is 

# WORKFLOW CONFIGURATION


### WORKFLOW CREATION.


#### Workflow Creation.

Request

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertWorkFlow>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel/>
         </requestHeader>
         <companyId>nable</companyId>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <workflowId></workflowId>
         <actionType>ESB_TEST_1</actionType>
         <debitAccount>103914021170</debitAccount>
         <amountFrom>5</amountFrom>
         <amountTo>6000</amountTo>
         <!--Optional:-->
         <listOfOptions>
            <!--Zero or more repetitions:-->
            <option>
             <optionId></optionId>
               <optionNumber>1</optionNumber>
               <!--Optional:-->
               <listOfLevels>
                  <!--Zero or more repetitions:-->
                  <level>
                     <levelId></levelId>
                     <levelNumber>1</levelNumber>
                     <groupId>217</groupId>
                     <noOfAuth>1</noOfAuth>
                     <paralellFlag>P</paralellFlag>
                  </level>
               </listOfLevels>
            </option>
         </listOfOptions>
      </uxp:submitUpsertWorkFlow>
   </soapenv:Body>
</soapenv:Envelope>

```

Response :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertWorkFlowResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertWorkFlowResponse>
   </soapenv:Body>
</soapenv:Envelope>

```


#### Check the Pending Workflow Create Requests.

Request : Request should be defferent user but same group of bank admin. Here we have used NEW_PENDING approval status filter.

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getPendingWorkflowRequests>
         <requestHeader>
            <bankAdminId>able</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <!--Optional:-->
         <companyId>nable</companyId>
         <!--Optional:-->
         <statusFlg>NEW_PENDING</statusFlg>
      </uxp:getPendingWorkflowRequests>
   </soapenv:Body>
</soapenv:Envelope>

```


Response :

```xml
            <workflow>
               <workflowId>503</workflowId>
               <approvalId>2812</approvalId>
               <current>
                  <actionType>STEST2</actionType>
                  <companyId>nable</companyId>
                  <debitAccount>1211111</debitAccount>
                  <amountFrom>1E+4</amountFrom>
                  <amountTo>9E+3</amountTo>
                  <listOfOptions>
                     <option>
                        <optionId>573</optionId>
                        <optionNumber>1</optionNumber>
                        <listOfLevels>
                           <level>
                              <levelId>774</levelId>
                              <levelNumber>1</levelNumber>
                              <groupId>217</groupId>
                              <noOfAuth>1</noOfAuth>
                              <paralellFlag/>
                           </level>
                        </listOfLevels>
                     </option>
                  </listOfOptions>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-13T11:25:44.000+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                  </auditDetails>
               </current>
               <modify>
                  <actionType>STEST2</actionType>
                  <companyId>nable</companyId>
                  <debitAccount>1211111</debitAccount>
                  <amountFrom>9000</amountFrom>
                  <amountTo>10000</amountTo>
                  <listOfOptions>
                     <option>
                        <optionId/>
                        <optionNumber>1</optionNumber>
                        <listOfLevels>
                           <level>
                              <levelId/>
                              <levelNumber>1</levelNumber>
                              <groupId>217</groupId>
                              <noOfAuth>1</noOfAuth>
                              <paralellFlag/>
                           </level>
                        </listOfLevels>
                     </option>
                  </listOfOptions>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-13T11:26:07.469+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy/>
                     <PendingModifiedDate/>
                  </auditDetails>
               </modify>
               <signature>0745f4495abe8f3f00c03037c638105237ae3eca918d2ae472c355662b5e9563</signature>
               <status>NEW_PENDING</status>
            </workflow>
         </listOfPendingWorkflows>
      </out:getPendingWorkflowRequestsResponse>
   </soapenv:Body>

```


With the given signature and the approval ID it is possible to Approve this request.

Then it will be removed from PENDING list. Then search from EXISTING API.


Request :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getExistingWorkFlowList>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId></companyId>
         <statusFlg>VERIFIED</statusFlg>
      </uxp:getExistingWorkFlowList>
   </soapenv:Body>
</soapenv:Envelope>

```


Response :

```xml

 <workflow>
               <workflowId>507</workflowId>
               <companyId>nable</companyId>
               <actionType>ESB_TEST_1</actionType>
               <debitAccount>103914021170</debitAccount>
               <amountFrom>5E+0</amountFrom>
               <amountTo>6E+3</amountTo>
               <listOfOptions>
                  <option>
                     <optionId>576</optionId>
                     <optionNumber>1</optionNumber>
                     <listOfLevels>
                        <level>
                           <levelId>777</levelId>
                           <levelNumber>1</levelNumber>
                           <groupId>217</groupId>
                           <noOfAuth>1</noOfAuth>
                           <paralellFlag>P</paralellFlag>
                        </level>
                     </listOfLevels>
                  </option>
               </listOfOptions>
               <auditDetails>
                  <createdBy>nable</createdBy>
                  <createdOn>2020-10-15T07:44:12.835+0000</createdOn>
                  <modifiedBy/>
                  <modifiedOn/>
                  <verifiedBy>able</verifiedBy>
                  <verifiedOn>2020-10-15T07:52:15.627+0000</verifiedOn>
                  <PendingModifiedBy/>
                  <PendingModifiedDate/>
               </auditDetails>
               <status>VERIFIED</status>
            </workflow>

```

Now this Request Can changed by any user.

Suppose same user updating the debit account to 1212121


Request :

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertWorkFlow>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel/>
         </requestHeader>
         <companyId>nable</companyId>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <workflowId>507</workflowId>
         <actionType>ESB_TEST_1</actionType>
         <debitAccount>1212121</debitAccount>
         <amountFrom>5</amountFrom>
         <amountTo>6000</amountTo>
         <!--Optional:-->
         <listOfOptions>
            <!--Zero or more repetitions:-->
            <option>
             <optionId>576</optionId>
               <optionNumber>1</optionNumber>
               <!--Optional:-->
               <listOfLevels>
                  <!--Zero or more repetitions:-->
                  <level>
                     <levelId>777</levelId>
                     <levelNumber>1</levelNumber>
                     <groupId>217</groupId>
                     <noOfAuth>1</noOfAuth>
                     <paralellFlag>P</paralellFlag>
                  </level>
               </listOfLevels>
            </option>
         </listOfOptions>
      </uxp:submitUpsertWorkFlow>
   </soapenv:Body>
</soapenv:Envelope>

```

Response :

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertWorkFlowResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertWorkFlowResponse>
   </soapenv:Body>
</soapenv:Envelope>

```


Now this is a modify Request. Check it from pendingAPI. Now current object should be the previsou one and modified object should be the updated one. Use MODIFY_PENDING filter.


Request :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getPendingWorkflowRequests>
         <requestHeader>
            <bankAdminId>able</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <!--Optional:-->
         <companyId>nable</companyId>
         <!--Optional:-->
         <statusFlg>MODIFY_PENDING</statusFlg>
      </uxp:getPendingWorkflowRequests>
   </soapenv:Body>
</soapenv:Envelope>
```

Response :

```xml

           <workflow>
               <workflowId>507</workflowId>
               <approvalId>2836</approvalId>
               <current>
                  <actionType>ESB_TEST_1</actionType>
                  <companyId>nable</companyId>
                  <debitAccount>103914021170</debitAccount>
                  <amountFrom>5E+0</amountFrom>
                  <amountTo>6E+3</amountTo>
                  <listOfOptions>
                     <option>
                        <optionId>576</optionId>
                        <optionNumber>1</optionNumber>
                        <listOfLevels>
                           <level>
                              <levelId>777</levelId>
                              <levelNumber>1</levelNumber>
                              <groupId>217</groupId>
                              <noOfAuth>1</noOfAuth>
                              <paralellFlag>P</paralellFlag>
                           </level>
                        </listOfLevels>
                     </option>
                  </listOfOptions>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T07:44:12.835+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy>able</verifiedBy>
                     <verifiedOn>2020-10-15T07:52:15.627+0000</verifiedOn>
                  </auditDetails>
               </current>
               <modify>
                  <actionType>ESB_TEST_1</actionType>
                  <companyId>nable</companyId>
                  <debitAccount>1212121</debitAccount>
                  <amountFrom>6E+3</amountFrom>
                  <amountTo>5</amountTo>
                  <listOfOptions>
                     <option>
                        <optionId>576</optionId>
                        <optionNumber>1</optionNumber>
                        <listOfLevels>
                           <level>
                              <levelId>777</levelId>
                              <levelNumber>1</levelNumber>
                              <groupId>217</groupId>
                              <noOfAuth>1</noOfAuth>
                              <paralellFlag>P</paralellFlag>
                           </level>
                        </listOfLevels>
                     </option>
                  </listOfOptions>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T08:19:57.606+0000</createdOn>
                     <modifiedBy>nable</modifiedBy>
                     <modifiedOn>2020-10-15T08:19:57.562+0000</modifiedOn>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy>nable</PendingModifiedBy>
                     <PendingModifiedDate>2020-10-15T13:49:57.562+0530</PendingModifiedDate>
                  </auditDetails>
               </modify>
               <signature>dbe3af5e241fdb4c01c58239fcda31ce2c4e6cbbf458d219f156ed452389ad13</signature>
               <status>MODIFY_PENDING</status>
            </workflow>


```



Whne a object is in Modify Pending status only the modified user can change it. Any other user cant modify it.

Now try to modify it again as user able  ( modified user is nable)

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertWorkFlow>
         <requestHeader>
            <bankAdminId>able</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel/>
         </requestHeader>
         <companyId>nable</companyId>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <workflowId>507</workflowId>
         <actionType>ESB_TEST_1</actionType>
         <debitAccount>1212121</debitAccount>
         <amountFrom>5</amountFrom>
         <amountTo>6000</amountTo>
         <!--Optional:-->
         <listOfOptions>
            <!--Zero or more repetitions:-->
            <option>
             <optionId>576</optionId>
               <optionNumber>1</optionNumber>
               <!--Optional:-->
               <listOfLevels>
                  <!--Zero or more repetitions:-->
                  <level>
                     <levelId>777</levelId>
                     <levelNumber>1</levelNumber>
                     <groupId>217</groupId>
                     <noOfAuth>1</noOfAuth>
                     <paralellFlag>P</paralellFlag>
                  </level>
               </listOfLevels>
            </option>
         </listOfOptions>
      </uxp:submitUpsertWorkFlow>
   </soapenv:Body>
</soapenv:Envelope>

```


Response :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertWorkFlowResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>Modification Request can be changed by modified user only.</statusDescription>
         </responseHeader>
      </out:submitUpsertWorkFlowResponse>
   </soapenv:Body>
</soapenv:Envelope>

```

Original modified user should be able to change it. Then his modification Request will replace the previous request. Change is  : Account number change to 333333


```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertWorkFlow>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel/>
         </requestHeader>
         <companyId>nable</companyId>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <workflowId>507</workflowId>
         <actionType>ESB_TEST_1</actionType>
         <debitAccount>33333</debitAccount>
         <amountFrom>5</amountFrom>
         <amountTo>6000</amountTo>
         <!--Optional:-->
         <listOfOptions>
            <!--Zero or more repetitions:-->
            <option>
             <optionId>576</optionId>
               <optionNumber>1</optionNumber>
               <!--Optional:-->
               <listOfLevels>
                  <!--Zero or more repetitions:-->
                  <level>
                     <levelId>777</levelId>
                     <levelNumber>1</levelNumber>
                     <groupId>217</groupId>
                     <noOfAuth>1</noOfAuth>
                     <paralellFlag>P</paralellFlag>
                  </level>
               </listOfLevels>
            </option>
         </listOfOptions>
      </uxp:submitUpsertWorkFlow>
   </soapenv:Body>
</soapenv:Envelope>


```

Response : 

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertWorkFlowResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertWorkFlowResponse>
   </soapenv:Body>
</soapenv:Envelope>

```


Check wether modify pending has the original current and new modify payloand in modify 


Request :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getPendingWorkflowRequests>
         <requestHeader>
            <bankAdminId>able</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <!--Optional:-->
         <companyId>nable</companyId>
         <!--Optional:-->
         <statusFlg>MODIFY_PENDING</statusFlg>
      </uxp:getPendingWorkflowRequests>
   </soapenv:Body>
</soapenv:Envelope>

```


Response : 

```xml
 <workflow>
               <workflowId>507</workflowId>
               <approvalId>2836</approvalId>
               <current>
                  <actionType>ESB_TEST_1</actionType>
                  <companyId>nable</companyId>
                  <debitAccount>103914021170</debitAccount>
                  <amountFrom>5E+0</amountFrom>
                  <amountTo>6E+3</amountTo>
                  <listOfOptions>
                     <option>
                        <optionId>576</optionId>
                        <optionNumber>1</optionNumber>
                        <listOfLevels>
                           <level>
                              <levelId>777</levelId>
                              <levelNumber>1</levelNumber>
                              <groupId>217</groupId>
                              <noOfAuth>1</noOfAuth>
                              <paralellFlag>P</paralellFlag>
                           </level>
                        </listOfLevels>
                     </option>
                  </listOfOptions>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T07:44:12.835+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy>able</verifiedBy>
                     <verifiedOn>2020-10-15T07:52:15.627+0000</verifiedOn>
                  </auditDetails>
               </current>
               <modify>
                  <actionType>ESB_TEST_1</actionType>
                  <companyId>nable</companyId>
                  <debitAccount>33333</debitAccount>
                  <amountFrom>6E+3</amountFrom>
                  <amountTo>5</amountTo>
                  <listOfOptions>
                     <option>
                        <optionId>576</optionId>
                        <optionNumber>1</optionNumber>
                        <listOfLevels>
                           <level>
                              <levelId>777</levelId>
                              <levelNumber>1</levelNumber>
                              <groupId>217</groupId>
                              <noOfAuth>1</noOfAuth>
                              <paralellFlag>P</paralellFlag>
                           </level>
                        </listOfLevels>
                     </option>
                  </listOfOptions>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T08:45:56.499+0000</createdOn>
                     <modifiedBy>nable</modifiedBy>
                     <modifiedOn>2020-10-15T08:45:56.495+0000</modifiedOn>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy>nable</PendingModifiedBy>
                     <PendingModifiedDate>2020-10-15T14:15:56.495+0530</PendingModifiedDate>
                  </auditDetails>
               </modify>
               <signature>cbe5025211dc6d49c5b83bb59de79343c1a5de1041e174e88ae84c785abde079</signature>
               <status>MODIFY_PENDING</status>
            </workflow>
         </listOfPendingWorkflows>

```


Then it is removed from pending API.

Check From Existing. Latst modified changes should have updated and the newPending details should be null.

Request :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getExistingWorkFlowList>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId></companyId>
         <statusFlg>VERIFIED</statusFlg>
      </uxp:getExistingWorkFlowList>
   </soapenv:Body>
</soapenv:Envelope>
```


Response :

```xml
 <workflow>
               <workflowId>507</workflowId>
               <companyId>nable</companyId>
               <actionType>ESB_TEST_1</actionType>
               <debitAccount>33333</debitAccount>
               <amountFrom>5E+0</amountFrom>
               <amountTo>6E+3</amountTo>
               <listOfOptions>
                  <option>
                     <optionId>576</optionId>
                     <optionNumber>1</optionNumber>
                     <listOfLevels>
                        <level>
                           <levelId>777</levelId>
                           <levelNumber>1</levelNumber>
                           <groupId>217</groupId>
                           <noOfAuth>1</noOfAuth>
                           <paralellFlag>P</paralellFlag>
                        </level>
                     </listOfLevels>
                  </option>
               </listOfOptions>
               <auditDetails>
                  <createdBy>nable</createdBy>
                  <createdOn>2020-10-15T07:44:12.835+0000</createdOn>
                  <modifiedBy>nable</modifiedBy>
                  <modifiedOn>2020-10-15T08:45:56.495+0000</modifiedOn>
                  <verifiedBy>able</verifiedBy>
                  <verifiedOn>2020-10-15T08:56:34.959+0000</verifiedOn>
                  <PendingModifiedBy/>
                  <PendingModifiedDate/>
               </auditDetails>
               <status>VERIFIED</status>
            </workflow>
         </listOfWorkflows>


```

***

# GROUPS CONFIGURATION

### Group Creation

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertGroup>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId>nable</companyId>
         <groupId></groupId>
         <groupName>ESB</groupName>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <ListOfUsers>
            <!--Zero or more repetitions:-->
            <user>
               <userName>SAMA</userName>
            </user>
         </ListOfUsers>
      </uxp:submitUpsertGroup>
   </soapenv:Body>
</soapenv:Envelope>

```

Response :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertGroupResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertGroupResponse>
   </soapenv:Body>
</soapenv:Envelope>
```

Get It form Pending.

Request :

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getAuthPendingGroups>
         <bankAdminId>able</bankAdminId>
         <bankAdminGroup>217</bankAdminGroup>
         <bankAdminLevel></bankAdminLevel>
      </uxp:getAuthPendingGroups>
   </soapenv:Body>
</soapenv:Envelope>

```


Response :

```xml

 <pendingGroup>
               <companyID>nable</companyID>
               <groupID>387</groupID>
               <authorizationId>2837</authorizationId>
               <signature>52290c32d552ea41645839f4cbfcd5d9adca02a734e17eefd30d6b1743c7ba34</signature>
               <current>
                  <groupName>ESB</groupName>
                  <status>NEW_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>SAMA</userName>
                        <userId>533</userId>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T09:08:21.170+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                  </auditDetails>
               </current>
               <modified>
                  <groupName>ESB</groupName>
                  <status>NEW_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>SAMA</userName>
                        <userId>533</userId>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T09:08:21.184+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy/>
                     <PendingModifiedDate/>
                  </auditDetails>
               </modified>
               <status>NEW_PENDING</status>
            </pendingGroup>

```

Now change the new pending by the same user.

Request : 

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertGroup>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId>nable</companyId>
         <groupId>387</groupId>
         <groupName>ESB</groupName>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <ListOfUsers>
            <!--Zero or more repetitions:-->
            <user>
             
               <userName>SAMA</userName>
            </user>
            <user>
             
               <userName>MALA</userName>
            </user>
         </ListOfUsers>
      </uxp:submitUpsertGroup>
   </soapenv:Body>
</soapenv:Envelope>


```

Response :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertGroupResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertGroupResponse>
   </soapenv:Body>
</soapenv:Envelope>

```


Check From Pending using same Requst used early.

```xml

 <pendingGroup>
               <companyID>nable</companyID>
               <groupID>387</groupID>
               <authorizationId>2837</authorizationId>
               <signature>873cf555cde28b7f16a63d8327293e65419f2a4aa7da412e2c36aec3da7c096e</signature>
               <current>
                  <groupName>ESB</groupName>
                  <status>NEW_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>SAMA</userName>
                        <userId>534</userId>
                     </user>
                     <user>
                        <userName>MALA</userName>
                        <userId>535</userId>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T13:12:04.751+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                  </auditDetails>
               </current>
               <modified>
                  <groupName>ESB</groupName>
                  <status>NEW_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>SAMA</userName>
                        <userId/>
                     </user>
                     <user>
                        <userName>MALA</userName>
                        <userId/>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T13:12:04.755+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy/>
                     <PendingModifiedDate/>
                  </auditDetails>
               </modified>
               <status>NEW_PENDING</status>
            </pendingGroup>


```

New user MALA has added to the current object and modified object due to this is NEW_PENDING. 

Check This APPROVED.

Dev Approval Module

http://10.30.2.111:9081/apprv/swagger-ui.html#/

{
  "approvalId": "2837",
  "approvalStatus": "VERIFIED"
}


Then Check From getExisting API whether MALA available in the verified object due to it is the latest change done by the same originated user.

Request :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:getListOfGroups>
         <requestHeader>
            <bankAdminId>admin</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId>nable</companyId>
      </uxp:getListOfGroups>
   </soapenv:Body>
</soapenv:Envelope>
```


Response :

```xml
 <group>
               <groupId>387</groupId>
               <groupName>ESB</groupName>
               <status>VERIFIED</status>
               <companyId>nable</companyId>
               <listOfUsers>
                  <user>
                     <userName>SAMA</userName>
                     <userId>534</userId>
                  </user>
                  <user>
                     <userName>MALA</userName>
                     <userId>535</userId>
                  </user>
               </listOfUsers>
               <auditDetails>
                  <createdBy>nable</createdBy>
                  <createdOn>2020-10-15T13:12:04.751+0000</createdOn>
                  <modifiedBy/>
                  <modifiedOn/>
                  <verifiedBy>able</verifiedBy>
                  <verifiedOn>2020-10-15T13:17:00.290+0000</verifiedOn>
                  <PendingModifiedBy/>
                  <PendingModifiedDate/>
               </auditDetails>
            </group>

```

Now Check Modifying and changing modifying request by the same user and another user.

Modifying senarios.

Verified objects can be modified by any user. group nme changed to ESBTEST.

Request :

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertGroup>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId>nable</companyId>
         <groupId>387</groupId>
         <groupName>ESBTEST</groupName>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <ListOfUsers>
            <!--Zero or more repetitions:-->
            <user>
             
               <userName>SAMA</userName>
            </user>
            <user>
             
               <userName>MALA</userName>
            </user>
         </ListOfUsers>
      </uxp:submitUpsertGroup>
   </soapenv:Body>
</soapenv:Envelope>

```

Response :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertGroupResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertGroupResponse>
   </soapenv:Body>
</soapenv:Envelope>

```

Check from pending.


```xml
    <pendingGroup>
               <companyID>nable</companyID>
               <groupID>387</groupID>
               <authorizationId>2839</authorizationId>
               <signature>cf312b02805fb116e3e94369c83d41f3348ed4051b4b0c29e4cf599fb1af2d8d</signature>
               <current>
                  <groupName>ESB</groupName>
                  <status>MODIFY_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>MALA</userName>
                        <userId>535</userId>
                     </user>
                     <user>
                        <userName>SAMA</userName>
                        <userId>534</userId>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T13:12:04.751+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy>able</verifiedBy>
                     <verifiedOn>2020-10-15T13:17:00.290+0000</verifiedOn>
                  </auditDetails>
               </current>
               <modified>
                  <groupName>ESBTEST</groupName>
                  <status>MODIFY_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>SAMA</userName>
                        <userId/>
                     </user>
                     <user>
                        <userName>MALA</userName>
                        <userId/>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T13:42:45.426+0000</createdOn>
                     <modifiedBy>nable</modifiedBy>
                     <modifiedOn>2020-10-15T13:42:45.394+0000</modifiedOn>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy/>
                     <PendingModifiedDate/>
                  </auditDetails>
               </modified>
               <status>MODIFY_PENDING</status>
            </pendingGroup>

```


Now try to again modify as new modify user . Change the one user name as KEMA

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertGroup>
         <requestHeader>
            <bankAdminId>able</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId>nable</companyId>
         <groupId>387</groupId>
         <groupName>ESBTEST</groupName>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <ListOfUsers>
            <!--Zero or more repetitions:-->
            <user>
             
               <userName>KEMA</userName>
            </user>
            <user>
             
               <userName>MALA</userName>
            </user>
         </ListOfUsers>
      </uxp:submitUpsertGroup>
   </soapenv:Body>
</soapenv:Envelope>


```

Response :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertGroupResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>Modification Request can be changed by modified user only.</statusDescription>
         </responseHeader>
      </out:submitUpsertGroupResponse>
   </soapenv:Body>
</soapenv:Envelope>
```


But it wanst success Then again try to modify the modify request by the modify originated user nable.

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uxp="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
   <soapenv:Header/>
   <soapenv:Body>
      <uxp:submitUpsertGroup>
         <requestHeader>
            <bankAdminId>nable</bankAdminId>
            <bankAdminGroup>217</bankAdminGroup>
            <bankAdminLevel></bankAdminLevel>
         </requestHeader>
         <companyId>nable</companyId>
         <groupId>387</groupId>
         <groupName>ESBTEST</groupName>
         <deleteFlag>N</deleteFlag>
         <!--Optional:-->
         <ListOfUsers>
            <!--Zero or more repetitions:-->
            <user>
             
               <userName>KEMA</userName>
            </user>
            <user>
             
               <userName>MALA</userName>
            </user>
         </ListOfUsers>
      </uxp:submitUpsertGroup>
   </soapenv:Body>
</soapenv:Envelope>

```

Response :

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <out:submitUpsertGroupResponse xmlns:out="http://www.sampath.lk/iib/oc/corp/admin/UXP_CorpAdminWorkflow/">
         <responseHeader>
            <statusCode>true</statusCode>
            <statusDescription>success.</statusDescription>
         </responseHeader>
      </out:submitUpsertGroupResponse>
   </soapenv:Body>
</soapenv:Envelope>

```

It was success due to Modified user can modify the object again. (Previous modify request will be ignored)

Now Check from pending.

```xml
 <pendingGroup>
               <companyID>nable</companyID>
               <groupID>387</groupID>
               <authorizationId>2839</authorizationId>
               <signature>585d8ba1827db4824e2b6a497d7748dc6ca5ec63e256f1bb202e2eca3aa6d3ce</signature>
               <current>
                  <groupName>ESB</groupName>
                  <status>MODIFY_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>SAMA</userName>
                        <userId>534</userId>
                     </user>
                     <user>
                        <userName>MALA</userName>
                        <userId>535</userId>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T13:12:04.751+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy>able</verifiedBy>
                     <verifiedOn>2020-10-15T13:17:00.290+0000</verifiedOn>
                  </auditDetails>
               </current>
               <modified>
                  <groupName>ESBTEST</groupName>
                  <status>MODIFY_PENDING</status>
                  <listOfUsers>
                     <user>
                        <userName>KEMA</userName>
                        <userId/>
                     </user>
                     <user>
                        <userName>MALA</userName>
                        <userId/>
                     </user>
                  </listOfUsers>
                  <auditDetails>
                     <createdBy>nable</createdBy>
                     <createdOn>2020-10-15T15:05:52.269+0000</createdOn>
                     <modifiedBy/>
                     <modifiedOn/>
                     <verifiedBy/>
                     <verifiedOn/>
                     <PendingModifiedBy/>
                     <PendingModifiedDate/>
                  </auditDetails>
               </modified>
               <status>MODIFY_PENDING</status>
            </pendingGroup>

```


Approve it from dual authenticaton and Check from get existing latest modificaiton should be the current object then.


```xml

  <group>
               <groupId>387</groupId>
               <groupName>FINALE</groupName>
               <status>VERIFIED</status>
               <companyId>nable</companyId>
               <listOfUsers>
                  <user>
                     <userName>KEMA</userName>
                     <userId>536</userId>
                  </user>
                  <user>
                     <userName>MALA</userName>
                     <userId>537</userId>
                  </user>
               </listOfUsers>
               <auditDetails>
                  <createdBy>nable</createdBy>
                  <createdOn>2020-10-15T13:12:04.751+0000</createdOn>
                  <modifiedBy>nable</modifiedBy>
                  <modifiedOn>2020-10-15T16:27:24.323+0000</modifiedOn>
                  <verifiedBy>able</verifiedBy>
                  <verifiedOn>2020-10-15T16:29:12.229+0000</verifiedOn>
                  <PendingModifiedBy/>
                  <PendingModifiedDate/>
               </auditDetails>
            </group>


```

***

