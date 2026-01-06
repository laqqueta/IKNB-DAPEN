/**
 * ICAMService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface ICAMService extends java.rmi.Remote {
    public java.lang.String getRegisteredEntity(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.String sectorCode, java.lang.String keyword, java.lang.Integer index, java.lang.Integer rowsTaken) throws java.rmi.RemoteException;
    public java.lang.String getEntityList(java.lang.Integer applicationId, java.lang.String sectorCode, java.lang.String keyword, java.lang.Integer page, java.lang.Integer rowsTaken) throws java.rmi.RemoteException;
    public java.lang.String getSingleApplicationEntity(java.lang.String entityCode) throws java.rmi.RemoteException;
    public java.lang.String getSingleApplicationEntityByNaturalCode(java.lang.String pNaturalEntityCode) throws java.rmi.RemoteException;
    public java.lang.String getEntityType(java.lang.String pEntityCode) throws java.rmi.RemoteException;
    public java.lang.Integer getCountNotif(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getNotif(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.Integer rowsTaken) throws java.rmi.RemoteException;
    public java.lang.String getMenus(java.lang.Integer userId, java.lang.Integer roleId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getMenuHierarchyBottomUpByUrl(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String getMenuByApplicationId(java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getChildrenFromMenu(java.lang.Integer menuId) throws java.rmi.RemoteException;
    public java.lang.String getSingleAksesMenu(java.lang.String url, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getSingleMenu(java.lang.String menuCode, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String searchCurrentActiveRoleByUserName(java.lang.String userName, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getSingleAksesRole(java.lang.Integer roleId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getAksesRoleChildren(java.lang.Integer roleId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getApplicationRole(java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getRoleChildren(java.lang.Integer pParentRoleId, java.lang.Integer pApplicationId) throws java.rmi.RemoteException;
    public java.lang.String getUserRoleOnApplication(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.Boolean deleteUserExt(java.lang.String xmlAksesUser, java.lang.String uName, java.lang.Integer appId, java.lang.Integer pRoleId) throws java.rmi.RemoteException;
    public java.lang.Integer searchUserIdByName(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String getSingleAksesUser1(java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.String getSingleAksesUser2(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getIntUserList(java.lang.String idNumber, java.lang.String namaPengguna, java.lang.Integer organizationId, java.lang.Integer activeFlag) throws java.rmi.RemoteException;
    public java.lang.String getExtUserList(java.lang.String idNumber, java.lang.String namaPengguna, java.lang.String entityName, java.lang.Integer activeFlag) throws java.rmi.RemoteException;
    public java.lang.Boolean isAuthenticated(java.lang.String username, java.lang.String password, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String activation(java.lang.String encPassword, java.lang.String bogus, java.lang.String sugob) throws java.rmi.RemoteException;
    public java.lang.Boolean activationUserExt(java.lang.String xmlAksesUser, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String changePassword(java.lang.String oldPassword, java.lang.String newPassword, java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.String requestResetPassword(java.lang.String resetMenuUrl, java.lang.String emailAddr) throws java.rmi.RemoteException;
    public java.lang.String resetPassword(java.lang.String encNewPassword, java.lang.String bogus, java.lang.String sugob) throws java.rmi.RemoteException;
    public java.lang.String addUserExt(java.lang.String xmlAksesUser, java.lang.String uName, java.lang.Integer appId, java.lang.Integer roleId, java.lang.Integer entityId) throws java.rmi.RemoteException;
    public java.lang.Boolean addUserApplication(java.lang.String pEmail, java.lang.String uName, java.lang.Integer appId, java.lang.Integer roleId) throws java.rmi.RemoteException;
    public java.lang.String getROUnderUserId(java.lang.Integer pAppId, java.lang.String pEntityCode, java.lang.String pRORoleCode, java.lang.Integer pUserId) throws java.rmi.RemoteException;
    public java.lang.Boolean updateUser(java.lang.String xmlAksesUser) throws java.rmi.RemoteException;
    public java.lang.String getSingleAksesUserApplication(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.Integer roleId) throws java.rmi.RemoteException;
    public java.lang.String getUserIdInUserApplication(java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getUserRoleIdOnApplication(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.Boolean isApplicationAccessGranted(java.lang.Integer userID, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getSingleApplication(java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getApplicationList(java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.String getAuthorizedApplicationList(java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.String getApplicationOrganizationList() throws java.rmi.RemoteException;
    public java.lang.String getOrganizationName(java.lang.Integer organizationId) throws java.rmi.RemoteException;
    public java.lang.String getListOfOrganizationByLevel(java.lang.Integer organizationLevel) throws java.rmi.RemoteException;
    public java.lang.String getSectorList(java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getSectorCode(java.lang.Integer sectorId) throws java.rmi.RemoteException;
    public java.lang.Integer getSectorId(java.lang.String sectorCode) throws java.rmi.RemoteException;
    public java.lang.String getSectorNameByCode(java.lang.String sectorCode) throws java.rmi.RemoteException;
    public java.lang.String getSingleSystemMessage(java.lang.String messageCode) throws java.rmi.RemoteException;
    public java.lang.String getSystemMessageList(java.lang.String codeKeyword) throws java.rmi.RemoteException;
    public java.lang.String getUserSector(java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.Boolean entityCheckOnUserSector(java.lang.Integer userId, java.lang.String entityCode) throws java.rmi.RemoteException;
    public java.lang.String getSingleSystemParamGen(java.lang.String paramGenCode) throws java.rmi.RemoteException;
    public java.lang.String getRoleMenu(java.lang.Integer roleId) throws java.rmi.RemoteException;
    public java.lang.String getRoleIdInRoleMenu(java.lang.Integer menuId) throws java.rmi.RemoteException;
    public java.lang.String getMenuGrantAccess(java.lang.String menuUrl, java.lang.Integer roleId, java.lang.Integer appId) throws java.rmi.RemoteException;
    public java.lang.String getSectorIdInApplicationSector(java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getEntity(java.lang.Integer userId, java.lang.Integer applicationId, java.lang.Integer rowsTaken) throws java.rmi.RemoteException;
    public java.lang.String generateMenuAuth(java.lang.Integer roleId) throws java.rmi.RemoteException;
    public java.lang.Boolean entityCheckOnUserEntity(java.lang.Integer userId, java.lang.String entityCode) throws java.rmi.RemoteException;
    public java.lang.String getUserEntity(java.lang.Integer entityId) throws java.rmi.RemoteException;
    public java.lang.Boolean entityCheckOnOrganizationEntity(java.lang.Integer organizationId, java.lang.String entityCode) throws java.rmi.RemoteException;
    public java.lang.String getListOfEnumerate(java.lang.String enumerateParentCode) throws java.rmi.RemoteException;
    public java.lang.String getSingleCustomLogUserActivity(java.lang.Integer userId, java.lang.Integer applicationId) throws java.rmi.RemoteException;
    public java.lang.String getUserAppRole(java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.String getUserOrg(java.lang.Integer userId) throws java.rmi.RemoteException;
    public java.lang.String getListOfDati1(java.util.Calendar effectiveDate) throws java.rmi.RemoteException;
    public java.lang.String getSingleDati1(java.lang.String locationCode, java.util.Calendar effectiveDate) throws java.rmi.RemoteException;
    public java.lang.String getListOfDati2(java.util.Calendar effectiveDate, java.lang.String parentLocationCode) throws java.rmi.RemoteException;
    public java.lang.String getSingleDati2(java.lang.String locationCode, java.util.Calendar effectiveDate) throws java.rmi.RemoteException;
    public java.lang.Integer getNewMessageCount(java.lang.String userName) throws java.rmi.RemoteException;
    public java.lang.String getTopMessage(java.lang.String userName) throws java.rmi.RemoteException;
    public java.lang.String getMessage(java.lang.String uName, java.lang.String keyword, java.lang.Integer pIndex, java.lang.Integer rowsTaken) throws java.rmi.RemoteException;
    public java.lang.String getSentItems(java.lang.String uName, java.lang.String keyword, java.lang.Integer pIndex, java.lang.Integer rowsTaken) throws java.rmi.RemoteException;
    public java.lang.String getSingleMessage(java.lang.Integer messageId) throws java.rmi.RemoteException;
    public java.lang.Boolean updateReadStatusMessage(java.lang.Integer messageId) throws java.rmi.RemoteException;
    public java.lang.Integer createMessage(java.lang.String xmlUserMessage) throws java.rmi.RemoteException;
    public java.lang.Boolean deleteInbox(java.lang.Integer msgId) throws java.rmi.RemoteException;
    public java.lang.Boolean deleteSentItem(java.lang.Integer msgId) throws java.rmi.RemoteException;
    public java.lang.String getMessageAttachment(java.lang.Integer msgId) throws java.rmi.RemoteException;
    public java.lang.Boolean updateMessageAttachment(java.lang.String fileBase64String, int[] messageId) throws java.rmi.RemoteException;
    public java.lang.String getTopAnnouncement(java.lang.Integer appId) throws java.rmi.RemoteException;
    public java.lang.String getSingleAnnouncement(java.lang.Integer announcementId) throws java.rmi.RemoteException;
    public java.lang.String getAllAnnouncement(java.lang.String search, java.lang.Integer appId) throws java.rmi.RemoteException;
    public java.lang.String getAnotherAnnouncement(java.lang.Integer exceptId, java.lang.Integer appId) throws java.rmi.RemoteException;
    public java.lang.String getAnnouncementAttachment(java.lang.Integer announcementId) throws java.rmi.RemoteException;
    public java.lang.String getTopLevelEconomicSector() throws java.rmi.RemoteException;
    public java.lang.String getEconomicSector(java.lang.String parentCode) throws java.rmi.RemoteException;
    public java.lang.String getWilayahKerjaOJK(java.lang.Integer organizationId) throws java.rmi.RemoteException;
    public java.lang.String getOrganizationHasWK() throws java.rmi.RemoteException;
    public java.lang.String getUserUnderEntityInAllBPRKS(java.lang.String token) throws java.rmi.RemoteException;
    public java.lang.String getUserUnderEntityInAllBUS(java.lang.String token) throws java.rmi.RemoteException;
    public java.lang.String getUserUnderEntitySector(java.lang.String token, java.lang.String[] sector) throws java.rmi.RemoteException;
    public java.lang.Integer getWorkingDays(java.util.Calendar pStartDate, java.util.Calendar pEndDate) throws java.rmi.RemoteException;
    public java.lang.Boolean isHoliday(java.util.Calendar pDate) throws java.rmi.RemoteException;
    public java.lang.String getHolidays(java.util.Calendar pStartDate, java.util.Calendar pEndDate) throws java.rmi.RemoteException;
    public java.lang.String getWorkingDaysBulk(java.lang.String xmlParamRequest) throws java.rmi.RemoteException;
}
