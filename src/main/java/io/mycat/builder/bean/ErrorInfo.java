package io.mycat.builder.bean;

/**
 * 错误信息的提示，用于界面展示
 * 
 * @author leader
 */
public class ErrorInfo {

	private final int code;
	private final boolean error;
	private final String message;

	public ErrorInfo(int code, boolean error, String message) {
		this.code = code;
		this.error = error;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public boolean isError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ErrorInfo [code=" + code + ", error=" + error + ", message=" + message + "]";
	}

}