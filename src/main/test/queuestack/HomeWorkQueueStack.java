package queuestack;

import com.jalasoft.minions.queue.HtmlReader;
import com.jalasoft.minions.queue.HtmlTag;
import com.jalasoft.minions.queue.Queue;
import com.jalasoft.minions.stack.Stack;

import java.io.IOException;

/**
 * Created by OPTIMUS on 22/05/2019.
 */
public class HomeWorkQueueStack {
    Stack stack = new Stack();

    Queue queue ;

    public HomeWorkQueueStack(){


    }

    public void readHtml(){
        try {
            queue= HtmlReader.getTagsFromHtmlFile(System.getProperty("user.dir")+"/test/queuestack/test.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int aux = 0;
        while(queue.getIndex(aux)!= null) {
            HtmlTag htmlTag=new HtmlTag(queue.getIndex(aux).toString(),true);
            if (htmlTag.isOpenTag()){
                stack.add(queue.getIndex(aux));
        }}

    }
}
