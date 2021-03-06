package DBM;

import java.io.IOException;

/** Demonstration of reading the MS-Windows Netscape History
 * under UNIX using DBM.java.
 * @version $Id: ReadHistNS.java,v 1.3 2004/09/08 20:13:29 ian Exp $
 */
public class ReadHistNS {
	public static void main(String[] unused) throws IOException {
		DBM d = new DBM("netscape.hst");
		byte[] ba;
		for (ba = d.firstkey(); ba != null; ba = d.nextkey(ba)) {
			System.out.println("Key=\"" + new String(ba) + '"');
			byte[] val = d.fetch(ba);
			for (int i=0; i<16&&i<val.length; i++) {
				System.out.print((short)val[i]);
				System.out.print(' ');
			}
		}
	}
}
