package exception;

/**
 * Created by yong on 2018-05-10.
 *
 * @author yong
 */
public class WrongInputException extends Throwable {
    public WrongInputException(String message) {
        super(message);
    }
}
