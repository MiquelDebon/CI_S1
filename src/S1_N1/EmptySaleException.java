package S1_N1;

import java.io.IOException;

public class EmptySaleException extends IOException{
    public EmptySaleException(){}
    public EmptySaleException(String message){
        System.out.println(message);
    }
}
