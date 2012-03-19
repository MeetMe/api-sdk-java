/*
 * Copyright 2012 Smartling, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this work except in compliance with the License.
 * You may obtain a copy of the License in the LICENSE file, or at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smartling.api.sdk.file;

import com.smartling.api.sdk.file.response.ApiResponse;
import com.smartling.api.sdk.file.response.FileList;
import com.smartling.api.sdk.file.response.FileStatus;
import com.smartling.api.sdk.file.response.UploadData;

public interface FileApiClientAdapter
{
    /**
     * Uploads a file for translation to the Smartling File API.
     *
     * @param fileType the type of file to upload
     * @param fileUri the identifier of the file
     * @param filePath the full path to the file on the local file system.
     * @param approveContent true if the file contents should be approved after uploading the file. Can be null. Null uses fileApi default of false.
     * @param fileEncoding the encoding of the file. Can be null but best if encoding is specified.
     * @return ApiResponse from a success response from the File API.
     * @throws FileApiException if an exception has occurred or non success is returned from the file api.
     */
    ApiResponse<UploadData> uploadFile(String fileType, String fileUri, String filePath, Boolean approveContent, String fileEncoding) throws FileApiException;

    /**
     * Get the translated (or original) file contents.
     *
     * @param fileUri the identifier of the file
     * @param locale the locale to retrieve the translation for, or null to request the original file.
     * @return the contents of the requested file.
     * @throws FileApiException if an exception has occurred or non success is returned from the file api.
     */
    String getFile(String fileUri, String locale) throws FileApiException;

    /**
     * Get the listing of translated files for the specified locale.
     *
     * @param fileListSearchParams the search parameters to use when querying for a list of files.
     * @return ApiResponse from a success response from the File API.
     * @throws FileApiException if an exception has occurred or non success is returned from the file api.
     */
    ApiResponse<FileList> getFilesList(FileListSearchParams fileListSearchParams) throws FileApiException;

    /**
     * Get the status of a file for the specified locale
     *
     * @param fileUri the identifier of the file
     * @param locale the locale
     * @return ApiResponse from a success response from the File API.
     * @throws FileApiException if an exception has occurred or non success is returned from the file api.
     */
    ApiResponse<FileStatus> getFileStatus(String fileUri, String locale) throws FileApiException;

}