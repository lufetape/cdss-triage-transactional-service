package exceptions;

import java.io.Serializable;

public class TransactionalServiceException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionalServiceException()
    {
        super();
    }
    
     public TransactionalServiceException(String mensaje)
    {
        super(mensaje);
    }
    
    public TransactionalServiceException(Throwable causa)
    {
        super(causa);
    }
    
    public TransactionalServiceException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }    

}


	
	

