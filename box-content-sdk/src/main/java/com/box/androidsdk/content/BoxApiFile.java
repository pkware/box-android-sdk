package com.box.androidsdk.content;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsFile;

/**
 * Represents the API of the file endpoint on Box. This class can be used to generate request objects
 * for each of the APIs exposed endpoints
 */
public class BoxApiFile extends BoxApi {

    /**
     * Constructs a BoxApiFile with the provided BoxSession
     *
     * @param session authenticated session to use with the BoxApiFile
     */
    public BoxApiFile(BoxSession session) {
        super(session);
    }

    /**
     * Gets the URL for files
     *
     * @return the file URL
     */
    protected String getFilesUrl() { return String.format(Locale.ENGLISH, "%s/files", getBaseUri()); }

    /**
     * Gets the URL for file information
     *
     * @param id    id of the file
     * @return the file information URL
     */
    protected String getFileInfoUrl(String id) { return String.format(Locale.ENGLISH, "%s/%s", getFilesUrl(), id); }

    /**
     * Gets the URL for uploading a file
     *
     * @return the file upload URL
     */
    protected String getFileUploadUrl() { return String.format(Locale.ENGLISH, "%s/files/content", getBaseUploadUri() ); }

    /**
     * Gets the URL for uploading a new version of a file
     *
     * @param id    id of the file
     * @return the file version upload URL
     */
    protected String getFileUploadNewVersionUrl(String id) { return String.format(Locale.ENGLISH, "%s/files/%s/content", getBaseUploadUri(), id); }

    /**
     * Gets the URL for downloading a file
     *
     * @param id    id of the file
     * @return  the file download URL
     */
    protected String getFileDownloadUrl(String id) { return getFileInfoUrl(id) + "/content"; }


    /**
     * Gets a request that retrieves information on a file
     *
     * @param id    id of file to retrieve info on
     * @return      request to get a files information
     */
    public BoxRequestsFile.GetFileInfo getInfoRequest(final String id) {
        BoxRequestsFile.GetFileInfo request = new BoxRequestsFile.GetFileInfo(id, getFileInfoUrl(id), mSession);
        return request;
    }

    /**
     * Gets a request that uploads a file from an input stream
     *
     * @param fileInputStream   input stream of the file
     * @param fileName  name of the new file
     * @param destinationFolderId   id of the parent folder for the new file
     * @return  request to upload a file from an input stream
     */
    public BoxRequestsFile.UploadFile getUploadRequest(InputStream fileInputStream, String fileName, String destinationFolderId){
        BoxRequestsFile.UploadFile request = new BoxRequestsFile.UploadFile(fileInputStream, fileName, destinationFolderId, getFileUploadUrl(), mSession);
        return request;
    }

    /**
     * Gets a request that uploads a new file version from an input stream
     *
     * @param fileInputStream   input stream of the new file version
     * @param destinationFileId id of the file to upload a new version of
     * @return  request to upload a new file version from an input stream
     */
    public BoxRequestsFile.UploadNewVersion getUploadNewVersionRequest(InputStream fileInputStream, String destinationFileId){
        BoxRequestsFile.UploadNewVersion request = new BoxRequestsFile.UploadNewVersion(fileInputStream, getFileUploadNewVersionUrl(destinationFileId), mSession);
        return request;
    }

    /**
     * Gets a request that downloads the given file to the provided outputStream. Developer is responsible for closing the outputStream provided.
     *
     * @param outputStream outputStream to write file contents to.
     * @param fileId the file id to download.
     * @return  request to download a file to an output stream
     */
    public BoxRequestsFile.DownloadFile getDownloadRequest(OutputStream outputStream, String fileId) {
            BoxRequestsFile.DownloadFile request = new BoxRequestsFile.DownloadFile(outputStream, getFileDownloadUrl(fileId),mSession);
            return request;
    }
}