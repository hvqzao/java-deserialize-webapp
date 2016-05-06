package hvqzao.java.deserialize.webapp.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.tomcat.util.codec.binary.Base64;

public class Serial {

	public static Object fromBase64(String s) throws IOException, ClassNotFoundException {
		byte[] data = new Base64().decode(s);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o = ois.readObject();
		ois.close();
		return o;
	}

	public static String toBase64(Serializable o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
		return new Base64().encodeToString(baos.toByteArray());
	}
}
