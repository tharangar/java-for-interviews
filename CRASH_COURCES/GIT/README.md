
## GIT CRASH COURCE


// push to git new branch

you are working in ApprovedAssingsData branch in local machine.

you want to push latest updates to new branch  ApprovedAssingsData_SOCC-1690 

```
Git creates a new branch named remoteBranchToBeCreated under my commits I did in localBranch.
git push -u origin localBranch:remoteBranchToBeCreated

Ex :
git push -u origin ApprovedAssingsData:ApprovedAssingsData_SOCC-1690 

```

Edit: this changes your current local branch's (possibly named localBranch) upstream to origin/remoteBranchToBeCreated. To fix that, simply type:
```
git branch --set-upstream-to=origin/localBranch
```
So your current local branch now tracks origin/localBranch back.