/**
* ���ķִʣ��������ƥ���㷨
* Author: FruitBasket
* Time: 2013/5/1
* Email: FruitBasket@qq.com
* Source code: github.com/Fruit-Basket
*/

package segmentation;

import java.io.IOException;

public class WordsHandle {
	public static final int MAXLEN=4;    //��������󳤶ȣ�ÿ�����������ֽ�
	private static String result;
	
	public void handle(){    //�������������������ȡ�ļ����ִʡ�������
		this.getProcessedArticle();
		ResultFile resultFile=new ResultFile();
		resultFile.saveProcessedArticle(result);
		System.out.println("�ִʽ��: "+result);
	}
	
	private void getProcessedArticle(){    //��ȡ�ļ����ִʣ�����ݴ���result��
		SourceFile sourceFile=new SourceFile();
		try {
			sourceFile.readArticle();
			sourceFile.readLexicon();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		System.out.println("���ڷִ���......");
		segment(sourceFile.getArticle(),sourceFile.getLexicon());
        System.out.println("�ִ���ϣ�");
	}
	
	private void segment(String article,SinglyLinkedList lexicon){    //ʹ���������ƥ�䷨�ִʣ���������result
         int article_len=article.length(); 
         String subString;
         int offset;
         
         while(article!=null&&article_len>0){
        	 if(article_len>MAXLEN){
        	     subString=article.substring(article_len-MAXLEN,article_len);
        	 }
        	  else{
        		 subString=article.substring(0,article_len);
        	 }
        	offset=inLexicon(subString,lexicon);
        	 article_len-=offset;
         }
         result=result.substring(0,result.length()-9);    //ȥ����׺
	}
	
	private int inLexicon(String subString,SinglyLinkedList lexicon){    //����ĳһ�ַ����Լ����Ӵ��Ƿ��ڴʿ���
		int subString_len=subString.length();
		int lexicon_len=lexicon.length();
		String temp=null;
		int i,j;
		for(i=0;i<subString_len;i++){     //�����Ӵ�
			for(j=1;j<=lexicon_len;j++){    //�����ʿ�
				//System.out.println("��������������"+lexicon.get(j));
				if( (temp=subString.substring(i)).equals( lexicon.get(j) ) ==true ){
					result=temp+"  /  "+result;    //�˴�result����һ��"null"����segment��ȥ��
					return MAXLEN-i;
				}
			}
		}
		result=temp+"  /  "+result;
		return 1;
	}
	
}
