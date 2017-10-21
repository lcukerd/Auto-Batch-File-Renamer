package renamer;

import java.io.File;

public class Logic {
	
	String before;
	String prepend;
	int add;
	
	Logic(String before,String prepend,int add)
	{
		this.before = before;
		this.prepend = prepend;
		this.add = add;
	}
	
	public String renamefiles(File old,boolean rename)
    {
		String oldpath = old.getAbsolutePath();
		String newname = renamelogic(old.getName());
		if (newname.equals("#failed@@"))
			return "failed!";
		File file2 = new File(oldpath.substring(0,oldpath.indexOf(old.getName()))+newname);

		if (rename)
		{
			boolean success = old.renameTo(file2);

			if (success) {
			   System.out.println("success");
			}
		}
		return newname;
    }
	    
    private String renamelogic(String oldname)
    {
    	String extension;
    	int startIndex = oldname.indexOf(before);
    	if (startIndex == -1)
    		return "#failed@@";
    	String parsedname = oldname.substring(startIndex + before.length(),oldname.length()-1);
    	String epnumS = "";
    	for (int i=0;i<parsedname.length();i++)
    	{
    		char ch = parsedname.charAt(i);
    		if (Character.isDigit(ch))
    			epnumS += ch;
    		else if (ch!=' ')
    			break;
    	}
    	int extensionIndex=0,temp=0;
    	while(temp != -1)
    	{
    		extensionIndex = temp;
    		temp = oldname.indexOf('.',extensionIndex+1);
    	}
    	extension = oldname.substring(extensionIndex);
    	epnumS = String.valueOf(Integer.parseInt(epnumS)+add);
    	System.out.println(prepend + epnumS+extension);
    	return prepend + epnumS+extension;
    }

}
