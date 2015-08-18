package com.meiyun.core.upload;

/**
 * 上传文件的信息
 * 
 * @author Administrator
 *
 */
public class FileEntity {
	
	private String fileName; // 文件名
	private String fileContentType; // 上传文件的类型
	private long fileSize; // 文件的大小，单位byte
	private String extName; // 文件扩展名
	private String fieldName; // 字段名称
	private String filePath; // 文件上传路径
	private String fileNote; // 文件说明
	private String rename; // 重命名文件
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileContentType
	 */
	public String getFileContentType() {
		return fileContentType;
	}
	/**
	 * @param fileContentType the fileContentType to set
	 */
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * @return the extName
	 */
	public String getExtName() {
		return extName;
	}
	/**
	 * @param extName the extName to set
	 */
	public void setExtName(String extName) {
		this.extName = extName;
	}
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the fileNote
	 */
	public String getFileNote() {
		return fileNote;
	}
	/**
	 * @param fileNote the fileNote to set
	 */
	public void setFileNote(String fileNote) {
		this.fileNote = fileNote;
	}
	/**
	 * @return the rename
	 */
	public String getRename() {
		return rename;
	}
	/**
	 * @param rename the rename to set
	 */
	public void setRename(String rename) {
		this.rename = rename;
	}

}
