package mx.habil.support;

public class HabilAppServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private static final String CAUSED_BY = "\nCausado por: ";
	private Throwable cause = null;

	  public HabilAppServiceException() {
	  }

	  public HabilAppServiceException(String msg) {
	    super(msg);
	  }

	  public HabilAppServiceException(Throwable cause) {
	    super();
	    this.cause = cause;
	  }

	  public HabilAppServiceException(String msg, Throwable cause) {
	    super(msg);
	    this.cause = cause;
	  }

	  public Throwable getCause() {
	    return cause;
	  }

	  public String toString() {
	    if (cause == null) {
	      return super.toString();
	    } else {
	      return super.toString() + CAUSED_BY + cause.toString();
	    }
	  }

	  public void printStackTrace() {
	    super.printStackTrace();
	    if (cause != null) {
	      System.err.println(CAUSED_BY);
	      cause.printStackTrace();
	    }
	  }

	  public void printStackTrace(java.io.PrintStream ps) {
	    super.printStackTrace(ps);
	    if (cause != null) {
	      ps.println(CAUSED_BY);
	      cause.printStackTrace(ps);
	    }
	  }

	  public void printStackTrace(java.io.PrintWriter pw) {
	    super.printStackTrace(pw);
	    if (cause != null) {
	      pw.println(CAUSED_BY);
	      cause.printStackTrace(pw);
	    }
	  }
}
