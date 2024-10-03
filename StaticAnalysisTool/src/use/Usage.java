package use;

import java.io.IOException;
import java.util.List;

import analyzer.ChangeTypeAnalyzer;
import promptmaker.PromptMaker;

public class Usage {

	public static void main(String[] args) throws IOException{
		String bp;//The production class before the change
		String ap;//The production class after the change
		String bt;//The test class before the change
		
    	bp = "D:\\桌面\\testset\\1\\old\\ControllerListener.java";
    	ap = "D:\\桌面\\testset\\1\\new\\ControllerListener.java";
    	bt = "D:\\桌面\\testset\\1\\old\\GUIBackendTest.java";
		
    	ChangeTypeAnalyzer anl = new ChangeTypeAnalyzer(bp, ap, bt);
    	List<String> res = anl.getChangeTypes();
    	int idx = 1;
    	System.out.println("ChangeTypes:");
    	for (String str: res){
    		System.out.println(idx + "." + str);
    		idx++;
    	}
    	System.out.println("\n\n");
    	// The above code is used to extract the change type
    	
    	String path = "D:\\Data";
		String examplespath = "D:\\Data\\examples";
		System.out.println("Prompt:");
    	PromptMaker mak = new PromptMaker(bp, ap, bt);
    	mak.setSampleSetAddress(path, examplespath);
    	StringBuilder prompt = mak.getPrompt();
    	System.out.println(prompt.toString());
    	// The above code is used to make prompt
	}

}
