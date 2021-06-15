# SQL BASICS.




# HQL NATIVE QUERY IN REPOSITORIES.

Assign Table and it's repository with native queries.


```
@Getter
@Setter
@Entity
@Table(name = "WORKFLOW_ASSIGN")
public class Assign {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORKFLOW_ASSIGN_SEQ")
	@SequenceGenerator(name = "WORKFLOW_ASSIGN_SEQ", sequenceName = "WORKFLOW_ASSIGN_SEQ", allocationSize = 1)
	@Column(name = "ASSIGN_ID")
	private Long assignId;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ASSIGN_ID", columnDefinition = "INTEGER", nullable = false)
//	private Integer assignId;

	@Column(name = "STATUS", columnDefinition = "VARCHAR(20)", nullable = false)
	private String status;

	@Column(name = "LEVEL", columnDefinition = "INTEGER", nullable = false)
	private Integer level;

	@Column(name = "TYPE", columnDefinition = "VARCHAR(50)", nullable = false)
	private String type;

	@Column(name = "SUB_TYPE", columnDefinition = "VARCHAR(50)")
	private String subType;

	@Column(name = "FLAG", columnDefinition = "VARCHAR(20)", nullable = false)
	private String flag;

	@Column(name = "COMPANY_ID", columnDefinition = "VARCHAR(20)", nullable = false)
	private String companyId;

	@Column(name = "GROUP_NAME", columnDefinition = "VARCHAR(20)", nullable = false)
	private String groupName;

	@Column(name = "WORKFLOW_ID")
	private Long workflowId;

	@Column(name = "REF_ID", columnDefinition = "VARCHAR(100)", nullable = false)
	private String referenceId;

	@Column(name = "OPTION", columnDefinition = "INTEGER", nullable = false)
	private Integer option;

	@Column(name = "RULE_ID", columnDefinition = "INTEGER", nullable = false)
	private Integer ruleId;
	
	@Column(name = "LEVEL_ID", columnDefinition = "INTEGER default '0'", nullable = false )
	private Integer levelId;

	@Column(name = "APPROVED_USER", columnDefinition = "VARCHAR(20)")
	private String approvedUser;

	@Column(name = "APPROVED_DATE", columnDefinition = "TIMESTAMP")
	private Date approvedDate;
	
	@Column(name = "OPEN_DATE", columnDefinition = "TIMESTAMP")
	private Date openDate;
	
	@Column(name = "EXPLAN", columnDefinition = "VARCHAR(2)", nullable = true)
	private String explan;
	
	@Column(name = "ACTION", columnDefinition = "VARCHAR(20)", nullable = true)
	private String action;

	@Column(name = "COMMENT", columnDefinition = "VARCHAR(550)", nullable = true)
	private String comment;
	
	@Column(name = "DOMAIN", columnDefinition = "VARCHAR(550)", nullable = true)
	private String domain;
	
	@Column(name = "CREATED_BY", columnDefinition = "VARCHAR(30)", nullable = true)
	private String createdBy;

	@Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP", nullable = true)
	private Date createdDate;
	
	
}


```

Now we are going to Create Repository class by implementing Crud Repository.


```
@Repository
public interface AssignRepository extends CrudRepository<Assign, Long> {


	// get Assings allocated to a userGrops for one company and List of types
	List<Assign> findAllByCompanyIdAndOptionAndLevelAndWorkflowIdAndStatus(String companyId, int option, int level, Long workflowId,String status);
	
	// get Assings allocated to a userGrops for one company and List of types
	List<Assign> findAllByCompanyIdAndDomainAndGroupNameAndTypeIn(String companyId,String domain, String  groupName, List<String> types);
	
	/*
	 * Sample native query 1
	 * @Query(value = "SELECT DISTINCT age "+
               "FROM my_table "+
               "WHERE firstname = :firstname AND lastname = :lastname " +
               "GROUP BY age " +
               "ORDER BY COUNT(*) DESC " +
               "LIMIT 1", nativeQuery = true)
	   int retrieveAgeByFirstNameAndLastName(@Param("firstname") String firstname,
                                      @Param("lastname") String lastname);
	 * 
	 */
	
	@Query(value = "SELECT * FROM SB_OC_COR_WORKFLOW.WORKFLOW_ASSIGN wfas WHERE wfas.COMPANY_ID = ?1 AND wfas.GROUP_NAME = ?2 AND wfas.DOMAIN = ?3 AND wfas.TYPE IN ?4 AND CREATED_BY <> ?5 ORDER BY wfas.REF_ID ASC ", nativeQuery = true)
	List<Assign> findAllByCompanyIdAndGroupNameAndDomainAndTypeInAndCreatedByNot(String companyId,String  groupName, String domain,  List<String> types, String userId);
	
	// For Authpending we have to get instead of created User
	List<Assign> findAllByCompanyIdAndDomainAndGroupNameAndTypeInAndCreatedByNot(String companyId,String domain, String  groupName, List<String> types, String userId);
	
	// Sample native query 2
	// get Assings allocated to a userGrops for one company and List of types
	/**@Query(value = "SELECT * "+
            "FROM SB_OC_COR_WF.WORKFLOW_ASSIGN "+
            "WHERE COMPANY_ID = :companyId AND TYPE IN (:types) " +
            "GROUP BY REF_ID " +
            "ORDER BY OPTION ASC " , nativeQuery = true)
          //  "LIMIT 1", nativeQuery = true)

     */	
	
	@Query(value = "SELECT * FROM SB_OC_COR_WORKFLOW.WORKFLOW_ASSIGN wfas WHERE wfas.COMPANY_ID = ?1 AND wfas.TYPE IN ?2 ORDER BY wfas.WORKFLOW_ID ASC ", nativeQuery = true)
	List<Assign> findAllByCompanyIdAndTypeIn(String companyId, List<String> types);
	
	
	@Query(value = "SELECT COUNT(wa.ASSIGN_ID) AS GRAVITY FROM SB_OC_COR_WORKFLOW.WORKFLOW_ASSIGN wa WHERE wa.REF_ID = ?1 AND wa.OPTION = ?2 AND wa.LEVEL = ?3 AND wa.FLAG = ?4 GROUP BY wa.REF_ID ORDER BY COUNT(wa.ASSIGN_ID) ASC LIMIT 1 ", nativeQuery = true)
	int getRemainingAssings(String reffenceId, int option, int level , String status);
	
	@Query(value = "SELECT COUNT(wa.ASSIGN_ID) AS GRAVITY FROM SB_OC_COR_WORKFLOW.WORKFLOW_ASSIGN wa WHERE wa.REF_ID = ?1 AND wa.APPROVED_USER = ?2  AND wa.FLAG = ?3 GROUP BY wa.REF_ID ORDER BY COUNT(wa.ASSIGN_ID) ASC LIMIT 1 ", nativeQuery = true)
	int getApprovedAssingsByaUser(String reffenceId, String userId, String status);
	
	Optional<Assign> findAllByReferenceIdAndApprovedUser(String referenceId, String approvedUser);
	



	List<Assign> findAllByCompanyIdAndDomainAndGroupNameAndWorkflowId(
			String companyId, String domain, String group, Long workflowId);
	
	@Transactional
	List<Assign> findAllByWorkflowIdAndStatus(Long workflowId, String status);

	@Transactional
	List<Assign> findAllByWorkflowId(Long workflowId);
	
}


```




By lookin at the above repository you will seee when there is no native query , you have to form the method name in a special format predefined for CrudRepository . 
Now there is another repository type jpa Repository .  If you want you can extends both at once.

