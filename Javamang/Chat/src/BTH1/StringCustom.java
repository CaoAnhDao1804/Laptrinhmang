package BTH1;

public class StringCustom {
	public String doiHoa(String str) {
		String chuoiHoa ="";
		char[] sc = str.toCharArray();
		for (int i=0; i<sc.length;i++) {
			int ascii = sc[i];
			
				if(ascii>=97&&ascii<=122) {
					ascii-=32;
					chuoiHoa+=(char) ascii;
				} else {
					chuoiHoa+=(char) ascii;
				}
			}	
		return chuoiHoa;
		
	}
	
	public String doiThuong(String str) {
		String chuoiThuong= "";
		char[] sc = str.toCharArray();
		for (int i=0; i<sc.length;i++) {
			int ascii = sc[i];
			
				if(ascii>=65&&ascii<=90) {
					ascii+=32;
					chuoiThuong+=(char) ascii;
				} else {
					chuoiThuong+=(char) ascii;
				}
			}	
		
		return chuoiThuong;
	}
	
	public int demTu(String str) {
		int sotu=0;
		String []tu = str.split(" ");
		
		for (int i = 0; i < tu.length; i++) {
			if(tu[i].compareTo("")==0) {
				continue;
			} else
				sotu+=1;

		}
		return sotu;
	}
	public static void main(String []args) {
		StringCustom custom = new StringCustom();
		String str = "Toi yeu   Que Huong";
		System.out.println(custom.doiHoa(str));
		System.out.println(custom.doiThuong(str));
		System.out.println(custom.demTu(str));
	}

}
