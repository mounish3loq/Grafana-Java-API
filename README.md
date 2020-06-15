Grafana-Java-API
A wrapper Library to use the Grafana HTTP API from Java.
This project requiers the GSON Library (2.8.5 or newer)


Grafana-Java-API
Structure
Config
Templates
Responses
Java Methodes
Methods
User
Organisation
Dashboard/Folder Search
Dashboard
Folder
Authentication API
Experimental API
Not yet integrated

Structure
This Chapter describes how the diffrent JSON File types correspont to each other and how they are use. Great thanks to joelittlejohn's jsonschema2pojo (https://github.com/joelittlejohn/jsonschema2pojo) which enabled an easy way to create the POJO's.

Config
The JSON files in this folder are used to create the config POJO's and contains information how each Grafana API can be accessed.

Templates
The JSON files in this folder are used to create the template POJO's which are used for API requests which require a body.

Responses
The JSON files in this folder are used to create the response POJO's which describes what kind of response the Grafana Server will send.

Java Methodes
The Java Methodes are either stored in ServerAdminAPI.java or OrgAdminAPI.java. The methodes combine the config POJO's with the template POJO's and return the corresponding response POJO's.


Methods
Name: public Method Name
Json Description: Corresponing Name in respective json description containing the HTTP Method, URL, Parameter(s), Response and Template Info
Scope: The Scope in which the method operates
Implemented: Java Method is implemented

User
Name	Json Description	Scope	Implemented
getUsers()	UsersList	AdminAPI	yes
getUserByID()	UserByID	AdminAPI	yes
getUserByLoginOrEmail()	UserByLoginEmail	AdminAPI	yes
getUserOrgsByID()	UserOrgsByID	AdminAPI	yes
getCurrUserContext()	CurrUserContext	AdminAPI	yes
createUser()	CreateUserConf	AdminAPI	no
updateUser()	UpdateUser	AdminAPI	no
switchUserOrgContext()	SwitchUserOrgContext	AdminAPI	yes
setPasswordByID()	SetPasswordByID	AdminAPI	no
SetPermissionByID()	SetPermissionByID	AdminAPI	no
deleteByID()	DeleteByID	AdminAPI	no
Organisation
Name	Json Description	Scope	Implemented
getOrgList()	OrgList	AdminAPI	yes
getCurrOrgList()	CurrOrgList	CurrOrgAPI	yes
getOrgByID()	OrgByID	AdminAPI	yes
getOrgByName()	OrgByName	AdminAPI	yes
getCurrOrgUsers()	CurrOrgUsers	CurrOrgAPI	yes
getOrgUsersByID()	OrgUsersByID	AdminAPI	yes
createOrg()	CreateOrg	AdminAPI	yes
updateOrgByID()	UpdateOrgByID	AdminAPI	no
updateOrgUserByID()	UpdateOrgUserByID	AdminAPI	no
updateCurrOrgUserByID()	UpdateCurrOrgUserByID	CurrOrgAPI	no
updateCurrOrg()	UpdateCurrOrg	CurrOrgAPI	no
addOrgUserByID()	AddOrgUserByID	AdminAPI	no
addOrgCurrUser()	AddOrgCurrUser	CurrOrgAPI	yes
deleteOrgByID()	DeleteOrgByID	AdminAPI	no
deleteCurrOrgUserByID()	DeleteCurrOrgUserByID	CurrOrgAPI	yes
deleteOrgUserByID()	DeleteOrgUserByID	AdminAPI	no
Dashboard/Folder Search
Name	Json Description	Scope	Implemented
searchFolderDashboard()	SearchGrafana	CurrOrgAPI	yes
Dashboard
Name	Json Description	Scope	Implemented
getDashboardByUid()	DashboardByUid	CurrOrgAPI	yes
getDashboardHome()	DashboardHome	CurrOrgAPI	yes
getDashboardTags()	DashboardTags	CurrOrgAPI	yes
createUpdateDashboard()	CreateUpdateDashboard	CurrOrgAPI	yes
deleteDashboardByUid()	DeleteDashboardByUid	CurrOrgAPI	yes
Folder
Name	Json Description	Scope	Implemented
getFolderList()	FolderList	CurrOrgAPI	yes
getFolderByUid()	FolderByUid	CurrOrgAPI	yes
getFolderByID()	FolderByID	CurrOrgAPI	yes
createFolder()	CreateFolder	CurrOrgAPI	yes
updateFolder()	UpdateFolder	CurrOrgAPI	no
deleteFolderByUid()	DeleteFolderByUid	CurrOrgAPI	no
Authentication API
Name	Json Description	Scope	Implemented
getApiKeyList()	ApiKeyList	AdminAPI	yes
createApiKey()	CreateApiKey	AdminAPI	yes
deleteApiKeyByID()	DeleteApiKeyByID	AdminAPI	yes
Experimental API
Not documented Grafana API calls

Name	Json Description	Scope	Implemented
createUserInvite()	CreateUserInvite	CurrOrgAPI	yes
Not yet integrated
Admin: http://docs.grafana.org/http_api/admin/
Alerting: http://docs.grafana.org/http_api/alerting/
Annotations: http://docs.grafana.org/http_api/annotations/
Dashboard Permissions: http://docs.grafana.org/http_api/dashboard_permissions/
Dashboard Versions: http://docs.grafana.org/http_api/dashboard_versions/
Data source: http://docs.grafana.org/http_api/data_source/
Folder Permissions: http://docs.grafana.org/http_api/folder_permissions/
Other: http://docs.grafana.org/http_api/other/
Preferences: http://docs.grafana.org/http_api/preferences/
Snapshot: http://docs.grafana.org/http_api/snapshot/
Team: http://docs.grafana.org/http_api/team/
