package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsUser;

/**
 * Represents the API of the User endpoint on Box. This class can be used to generate request objects
 * for each of the APIs exposed endpoints
 */
public class BoxApiUser extends BoxApi {

    /**
     * Constructs a BoxApiUser with the provided BoxSession
     *
     * @param session authenticated session to use with the BoxApiUser
     */
    public BoxApiUser(BoxSession session) {
        super(session);
    }

    /**
     * Gets the URL for getting information of the current user
     *
     * @return the URL string for getting information of the current user
     */
    protected String getUsersUrl() { return String.format("%s/users", getBaseUri()); }


    /**
     * Gets the URL for getting information of the current user
     *
     * @return the URL string for getting information of the current user
     */
    protected String getUserInformationUrl(String id) { return String.format("%s/%s", getUsersUrl(), id); }


    /**
     * Gets a request that gets information about the current user
     *
     * @return request to get information about the current user
     */
        public BoxRequestsUser.GetUserInfo getCurrentUserInfoRequest() {
            BoxRequestsUser.GetUserInfo request = new BoxRequestsUser.GetUserInfo(getUserInformationUrl("me"), mSession);
        return request;
    }
}
