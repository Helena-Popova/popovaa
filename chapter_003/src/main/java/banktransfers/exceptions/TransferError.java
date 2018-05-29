package banktransfers.exceptions;

public class TransferError extends RuntimeException{
    public TransferError (String tr) {
        super(tr);
    }
}
