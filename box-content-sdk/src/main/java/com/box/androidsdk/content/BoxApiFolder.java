package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFolder;

/**
 * Represents the API of the folder endpoint on Box. This class can be used to generate request objects
 * for each of the APIs exposed endpoints
 */
public class BoxApiFolder extends BoxApi {

    /**
     * Constructs a BoxApiFolder with the provided BoxSession
     *
     * @param session authenticated session to use with the BoxApiFolder
     */
    public BoxApiFolder(BoxSession session) {
        super(session);
    }

    /**
     * Gets the URL for folders
     *
     * @return the folder URL
     */
    protected String getFoldersUrl() { return String.format("%s/folders", getBaseUri()); }

    /**
     * Gets the URL for folder information
     *
     * @param id    id of the folder
     * @return the folder information URL
     */
    protected String getFolderInfoUrl(String id) { return String.format("%s/%s", getFoldersUrl(), id); }

    /**
     * Gets the URL for items
     *
     * @param id    id of the folder
     * @return the folder items URL
     */
    protected String getFolderItemsUrl(String id) { return getFolderInfoUrl(id) + "/items"; }


    /**
     * Gets a request that retrieves information on a folder
     *
     * @param id    id of folder to retrieve info on
     * @return      request to get a folders information
     */
    public BoxRequestsFolder.GetFolderInfo getInfoRequest(String id) {
        BoxRequestsFolder.GetFolderInfo request = new BoxRequestsFolder.GetFolderInfo(id, getFolderInfoUrl(id), mSession);
        return request;
    }


    /**
     * Gets a request that retrieves the items of a folder
     *
     * @param id    id of folder to get children on
     * @return      request to get a folders children
     */
    public BoxRequestsFolder.GetFolderItems getItemsRequest(String id) {
        BoxRequestsFolder.GetFolderItems request = new BoxRequestsFolder.GetFolderItems(id, getFolderItemsUrl(id), mSession);
        return request;
    }


    /**
     * Gets a request that creates a folder in a parent folder
     *
     * @param parentId  id of the parent folder to create the folder in
     * @param name      name of the new folder
     * @return      request to create a folder
     */
    public BoxRequestsFolder.CreateFolder getCreateRequest(String parentId, String name) {
        BoxRequestsFolder.CreateFolder request = new BoxRequestsFolder.CreateFolder(parentId, name, getFoldersUrl(), mSession);
        return request;
    }
}