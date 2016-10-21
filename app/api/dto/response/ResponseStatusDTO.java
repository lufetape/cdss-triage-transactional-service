package api.dto.response;

public class ResponseStatusDTO {

	private int code;
	private Severity severity;
	private String message;
	private String developerMessage;

	public ResponseStatusDTO() {
		super();
	}

	public ResponseStatusDTO(int code) {
		super();
		this.code = code;
	}

	public ResponseStatusDTO(int code, Severity severity, String message) {
		super();
		this.code = code;
		this.severity = severity;
		this.message = message;
	}

	public ResponseStatusDTO(int code, Severity severity, String message, String developerMessage) {
		super();
		this.code = code;
		this.severity = severity;
		this.message = message;
		this.developerMessage = developerMessage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public static ResponseStatusDTO createOkRequestResponse(String message) {
		ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO();
		responseStatusDTO.setCode(0);
		responseStatusDTO.setMessage(message);
		responseStatusDTO.setSeverity(Severity.INFO);
		return responseStatusDTO;
	}
	
	public static ResponseStatusDTO createWarnRequestResponse(int code, String message) {
		ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO();
		responseStatusDTO.setCode(code);
		responseStatusDTO.setMessage(message);
		responseStatusDTO.setSeverity(Severity.WARN);
		return responseStatusDTO;
	}
	
	public static ResponseStatusDTO createWarnRequestResponse(int code, String message, Exception exception) {
		ResponseStatusDTO responseStatusDTO = createWarnRequestResponse(code, message);
		responseStatusDTO.setDeveloperMessage(exception.fillInStackTrace().toString());
		return responseStatusDTO;
	}
	
	public static ResponseStatusDTO createErrorRequestResponse(int code, String message) {
		ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO();
		responseStatusDTO.setCode(code);
		responseStatusDTO.setMessage(message);
		responseStatusDTO.setSeverity(Severity.ERROR);
		return responseStatusDTO;
	}

	public static ResponseStatusDTO createErrorRequestResponse(int code, String message, Exception exception) {
		ResponseStatusDTO responseStatusDTO = createErrorRequestResponse(code, message);
		responseStatusDTO.setDeveloperMessage(exception.fillInStackTrace().toString());
		return responseStatusDTO;
	}

	public static enum Severity {
		INFO, WARN, ERROR
	}

	@Override
	public String toString() {
		return "ResponseStatusDTO [code=" + code + ", severity=" + severity + ", message=" + message
				+ ", developerMessage=" + developerMessage + "]";
	}

}
