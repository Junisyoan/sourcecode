package xyz.cymedical.biz.impl.jun;


import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

public class BaseImpl {

	protected int firstRecord;			//锛屽叾瀹為〉鐮�
	protected int lastRecord;				//锛�
	protected int limit;				//锛屽垎鍑犳潯
	protected RowBounds rowBounds;		//锛屽垎椤电殑鑼冨洿
	protected boolean isUpdate;			//锛屾槸鍚︽墽琛屾垚鍔�
	protected boolean isExist;			//锛屾槸鍚﹀瓨鍦�
	protected int line;					//锛屾墽琛屼簡鍑犳潯
	protected Logger logger;			//锛屾棩蹇楁枃浠�
}
