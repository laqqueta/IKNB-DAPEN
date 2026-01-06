package org.tempuri;

public class ICAMServiceProxy implements org.tempuri.ICAMService {
  private String _endpoint = null;
  private org.tempuri.ICAMService iCAMService = null;
  
  public ICAMServiceProxy() {
    _initICAMServiceProxy();
  }
  
  public ICAMServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initICAMServiceProxy();
  }
  
  private void _initICAMServiceProxy() {
    try {
      CAMServiceLocator csl = new org.tempuri.CAMServiceLocator();
      csl.setBasicHttpBinding_ICAMServiceEndpointAddress(_endpoint);
      iCAMService = csl.getBasicHttpBinding_ICAMService();
    }
    catch (javax.xml.rpc.ServiceException serviceException) {
    }
    if (iCAMService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iCAMService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iCAMService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iCAMService != null)
      ((javax.xml.rpc.Stub)iCAMService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ICAMService getICAMService() {
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService;
  }
  
  public java.lang.String getRegisteredEntity(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.String sectorCode, java.lang.String keyword, java.lang.Integer index, java.lang.Integer rowsTaken) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getRegisteredEntity(userId, applicationId, sectorCode, keyword, index, rowsTaken);
  }
  
  public java.lang.String getEntityList(java.lang.Integer applicationId, java.lang.String sectorCode, java.lang.String keyword, java.lang.Integer page, java.lang.Integer rowsTaken) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getEntityList(applicationId, sectorCode, keyword, page, rowsTaken);
  }
  
  public java.lang.String getSingleApplicationEntity(java.lang.String entityCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleApplicationEntity(entityCode);
  }
  
  public java.lang.String getSingleApplicationEntityByNaturalCode(java.lang.String pNaturalEntityCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleApplicationEntityByNaturalCode(pNaturalEntityCode);
  }
  
  public java.lang.String getEntityType(java.lang.String pEntityCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getEntityType(pEntityCode);
  }
  
  public java.lang.Integer getCountNotif(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getCountNotif(userId, applicationId);
  }
  
  public java.lang.String getNotif(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.Integer rowsTaken) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getNotif(userId, applicationId, rowsTaken);
  }
  
  public java.lang.String getMenus(java.lang.Integer userId, java.lang.Integer roleId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getMenus(userId, roleId, applicationId);
  }
  
  public java.lang.String getMenuHierarchyBottomUpByUrl(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.String url) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getMenuHierarchyBottomUpByUrl(userId, applicationId, url);
  }
  
  public java.lang.String getMenuByApplicationId(java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getMenuByApplicationId(applicationId);
  }
  
  public java.lang.String getChildrenFromMenu(java.lang.Integer menuId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getChildrenFromMenu(menuId);
  }
  
  public java.lang.String getSingleAksesMenu(java.lang.String url, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleAksesMenu(url, applicationId);
  }
  
  public java.lang.String getSingleMenu(java.lang.String menuCode, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleMenu(menuCode, applicationId);
  }
  
  public java.lang.String searchCurrentActiveRoleByUserName(java.lang.String userName, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.searchCurrentActiveRoleByUserName(userName, applicationId);
  }
  
  public java.lang.String getSingleAksesRole(java.lang.Integer roleId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleAksesRole(roleId, applicationId);
  }
  
  public java.lang.String getAksesRoleChildren(java.lang.Integer roleId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getAksesRoleChildren(roleId, applicationId);
  }
  
  public java.lang.String getApplicationRole(java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getApplicationRole(applicationId);
  }
  
  public java.lang.String getRoleChildren(java.lang.Integer pParentRoleId, java.lang.Integer pApplicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getRoleChildren(pParentRoleId, pApplicationId);
  }
  
  public java.lang.String getUserRoleOnApplication(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserRoleOnApplication(userId, applicationId);
  }
  
  public java.lang.Boolean deleteUserExt(java.lang.String xmlAksesUser, java.lang.String uName, java.lang.Integer appId, java.lang.Integer pRoleId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.deleteUserExt(xmlAksesUser, uName, appId, pRoleId);
  }
  
  public java.lang.Integer searchUserIdByName(java.lang.String username) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.searchUserIdByName(username);
  }
  
  public java.lang.String getSingleAksesUser1(java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleAksesUser1(userId);
  }
  
  public java.lang.String getSingleAksesUser2(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleAksesUser2(username, password);
  }
  
  public java.lang.String getIntUserList(java.lang.String idNumber, java.lang.String namaPengguna, java.lang.Integer organizationId, java.lang.Integer activeFlag) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getIntUserList(idNumber, namaPengguna, organizationId, activeFlag);
  }
  
  public java.lang.String getExtUserList(java.lang.String idNumber, java.lang.String namaPengguna, java.lang.String entityName, java.lang.Integer activeFlag) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getExtUserList(idNumber, namaPengguna, entityName, activeFlag);
  }
  
  public java.lang.Boolean isAuthenticated(java.lang.String username, java.lang.String password, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.isAuthenticated(username, password, applicationId);
  }
  
  public java.lang.String activation(java.lang.String encPassword, java.lang.String bogus, java.lang.String sugob) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.activation(encPassword, bogus, sugob);
  }
  
  public java.lang.Boolean activationUserExt(java.lang.String xmlAksesUser, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.activationUserExt(xmlAksesUser, applicationId);
  }
  
  public java.lang.String changePassword(java.lang.String oldPassword, java.lang.String newPassword, java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.changePassword(oldPassword, newPassword, userId);
  }
  
  public java.lang.String requestResetPassword(java.lang.String resetMenuUrl, java.lang.String emailAddr) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.requestResetPassword(resetMenuUrl, emailAddr);
  }
  
  public java.lang.String resetPassword(java.lang.String encNewPassword, java.lang.String bogus, java.lang.String sugob) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.resetPassword(encNewPassword, bogus, sugob);
  }
  
  public java.lang.String addUserExt(java.lang.String xmlAksesUser, java.lang.String uName, java.lang.Integer appId, java.lang.Integer roleId, java.lang.Integer entityId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.addUserExt(xmlAksesUser, uName, appId, roleId, entityId);
  }
  
  public java.lang.Boolean addUserApplication(java.lang.String pEmail, java.lang.String uName, java.lang.Integer appId, java.lang.Integer roleId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.addUserApplication(pEmail, uName, appId, roleId);
  }
  
  public java.lang.String getROUnderUserId(java.lang.Integer pAppId, java.lang.String pEntityCode, java.lang.String pRORoleCode, java.lang.Integer pUserId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getROUnderUserId(pAppId, pEntityCode, pRORoleCode, pUserId);
  }
  
  public java.lang.Boolean updateUser(java.lang.String xmlAksesUser) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.updateUser(xmlAksesUser);
  }
  
  public java.lang.String getSingleAksesUserApplication(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.Integer roleId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleAksesUserApplication(userId, applicationId, roleId);
  }
  
  public java.lang.String getUserIdInUserApplication(java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserIdInUserApplication(applicationId);
  }
  
  public java.lang.String getUserRoleIdOnApplication(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserRoleIdOnApplication(userId, applicationId);
  }
  
  public java.lang.Boolean isApplicationAccessGranted(java.lang.Integer userID, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.isApplicationAccessGranted(userID, applicationId);
  }
  
  public java.lang.String getSingleApplication(java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleApplication(applicationId);
  }
  
  public java.lang.String getApplicationList(java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getApplicationList(userId);
  }
  
  public java.lang.String getAuthorizedApplicationList(java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getAuthorizedApplicationList(userId);
  }
  
  public java.lang.String getApplicationOrganizationList() throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getApplicationOrganizationList();
  }
  
  public java.lang.String getOrganizationName(java.lang.Integer organizationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getOrganizationName(organizationId);
  }
  
  public java.lang.String getListOfOrganizationByLevel(java.lang.Integer organizationLevel) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getListOfOrganizationByLevel(organizationLevel);
  }
  
  public java.lang.String getSectorList(java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSectorList(applicationId);
  }
  
  public java.lang.String getSectorCode(java.lang.Integer sectorId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSectorCode(sectorId);
  }
  
  public java.lang.Integer getSectorId(java.lang.String sectorCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSectorId(sectorCode);
  }
  
  public java.lang.String getSectorNameByCode(java.lang.String sectorCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSectorNameByCode(sectorCode);
  }
  
  public java.lang.String getSingleSystemMessage(java.lang.String messageCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleSystemMessage(messageCode);
  }
  
  public java.lang.String getSystemMessageList(java.lang.String codeKeyword) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSystemMessageList(codeKeyword);
  }
  
  public java.lang.String getUserSector(java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserSector(userId);
  }
  
  public java.lang.Boolean entityCheckOnUserSector(java.lang.Integer userId, java.lang.String entityCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.entityCheckOnUserSector(userId, entityCode);
  }
  
  public java.lang.String getSingleSystemParamGen(java.lang.String paramGenCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleSystemParamGen(paramGenCode);
  }
  
  public java.lang.String getRoleMenu(java.lang.Integer roleId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getRoleMenu(roleId);
  }
  
  public java.lang.String getRoleIdInRoleMenu(java.lang.Integer menuId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getRoleIdInRoleMenu(menuId);
  }
  
  public java.lang.String getMenuGrantAccess(java.lang.String menuUrl, java.lang.Integer roleId, java.lang.Integer appId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getMenuGrantAccess(menuUrl, roleId, appId);
  }
  
  public java.lang.String getSectorIdInApplicationSector(java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSectorIdInApplicationSector(applicationId);
  }
  
  public java.lang.String getEntity(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.Integer rowsTaken) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getEntity(userId, applicationId, rowsTaken);
  }
  
  public java.lang.String generateMenuAuth(java.lang.Integer roleId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.generateMenuAuth(roleId);
  }
  
  public java.lang.Boolean entityCheckOnUserEntity(java.lang.Integer userId, java.lang.String entityCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.entityCheckOnUserEntity(userId, entityCode);
  }
  
  public java.lang.String getUserEntity(java.lang.Integer entityId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserEntity(entityId);
  }
  
  public java.lang.Boolean entityCheckOnOrganizationEntity(java.lang.Integer organizationId, java.lang.String entityCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.entityCheckOnOrganizationEntity(organizationId, entityCode);
  }
  
  public java.lang.String getListOfEnumerate(java.lang.String enumerateParentCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getListOfEnumerate(enumerateParentCode);
  }
  
  public java.lang.String getSingleCustomLogUserActivity(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleCustomLogUserActivity(userId, applicationId);
  }
  
  public java.lang.String getUserAppRole(java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserAppRole(userId);
  }
  
  public java.lang.String getUserOrg(java.lang.Integer userId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserOrg(userId);
  }
  
  public java.lang.String getListOfDati1(java.util.Calendar effectiveDate) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getListOfDati1(effectiveDate);
  }
  
  public java.lang.String getSingleDati1(java.lang.String locationCode, java.util.Calendar effectiveDate) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleDati1(locationCode, effectiveDate);
  }
  
  public java.lang.String getListOfDati2(java.util.Calendar effectiveDate, java.lang.String parentLocationCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getListOfDati2(effectiveDate, parentLocationCode);
  }
  
  public java.lang.String getSingleDati2(java.lang.String locationCode, java.util.Calendar effectiveDate) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleDati2(locationCode, effectiveDate);
  }
  
  public java.lang.Integer getNewMessageCount(java.lang.String userName) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getNewMessageCount(userName);
  }
  
  public java.lang.String getTopMessage(java.lang.String userName) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getTopMessage(userName);
  }
  
  public java.lang.String getMessage(java.lang.String uName, java.lang.String keyword, java.lang.Integer pIndex, java.lang.Integer rowsTaken) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getMessage(uName, keyword, pIndex, rowsTaken);
  }
  
  public java.lang.String getSentItems(java.lang.String uName, java.lang.String keyword, java.lang.Integer pIndex, java.lang.Integer rowsTaken) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSentItems(uName, keyword, pIndex, rowsTaken);
  }
  
  public java.lang.String getSingleMessage(java.lang.Integer messageId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleMessage(messageId);
  }
  
  public java.lang.Boolean updateReadStatusMessage(java.lang.Integer messageId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.updateReadStatusMessage(messageId);
  }
  
  public java.lang.Integer createMessage(java.lang.String xmlUserMessage) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.createMessage(xmlUserMessage);
  }
  
  public java.lang.Boolean deleteInbox(java.lang.Integer msgId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.deleteInbox(msgId);
  }
  
  public java.lang.Boolean deleteSentItem(java.lang.Integer msgId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.deleteSentItem(msgId);
  }
  
  public java.lang.String getMessageAttachment(java.lang.Integer msgId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getMessageAttachment(msgId);
  }
  
  public java.lang.Boolean updateMessageAttachment(java.lang.String fileBase64String, int[] messageId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.updateMessageAttachment(fileBase64String, messageId);
  }
  
  public java.lang.String getTopAnnouncement(java.lang.Integer appId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getTopAnnouncement(appId);
  }
  
  public java.lang.String getSingleAnnouncement(java.lang.Integer announcementId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getSingleAnnouncement(announcementId);
  }
  
  public java.lang.String getAllAnnouncement(java.lang.String search, java.lang.Integer appId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getAllAnnouncement(search, appId);
  }
  
  public java.lang.String getAnotherAnnouncement(java.lang.Integer exceptId, java.lang.Integer appId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getAnotherAnnouncement(exceptId, appId);
  }
  
  public java.lang.String getAnnouncementAttachment(java.lang.Integer announcementId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getAnnouncementAttachment(announcementId);
  }
  
  public java.lang.String getTopLevelEconomicSector() throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getTopLevelEconomicSector();
  }
  
  public java.lang.String getEconomicSector(java.lang.String parentCode) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getEconomicSector(parentCode);
  }
  
  public java.lang.String getWilayahKerjaOJK(java.lang.Integer organizationId) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getWilayahKerjaOJK(organizationId);
  }
  
  public java.lang.String getOrganizationHasWK() throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getOrganizationHasWK();
  }
  
  public java.lang.String getUserUnderEntityInAllBPRKS(java.lang.String token) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserUnderEntityInAllBPRKS(token);
  }
  
  public java.lang.String getUserUnderEntityInAllBUS(java.lang.String token) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserUnderEntityInAllBUS(token);
  }
  
  public java.lang.String getUserUnderEntitySector(java.lang.String token, java.lang.String[] sector) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getUserUnderEntitySector(token, sector);
  }
  
  public java.lang.Integer getWorkingDays(java.util.Calendar pStartDate, java.util.Calendar pEndDate) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getWorkingDays(pStartDate, pEndDate);
  }
  
  public java.lang.Boolean isHoliday(java.util.Calendar pDate) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.isHoliday(pDate);
  }
  
  public java.lang.String getHolidays(java.util.Calendar pStartDate, java.util.Calendar pEndDate) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getHolidays(pStartDate, pEndDate);
  }
  
  public java.lang.String getWorkingDaysBulk(java.lang.String xmlParamRequest) throws java.rmi.RemoteException{
    if (iCAMService == null)
      _initICAMServiceProxy();
    return iCAMService.getWorkingDaysBulk(xmlParamRequest);
  }
  
  
}