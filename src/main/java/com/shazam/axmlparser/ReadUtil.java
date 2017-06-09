package com.shazam.axmlparser;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("ALL")
public class ReadUtil {

    private ReadUtil() {
    }

    public static final void readCheckType(InputStream stream, int expectedType) throws IOException {
        int type = readInt(stream);
        if (type != expectedType) {
            throw new IOException(
                    "Expected chunk of type 0x" + Integer.toHexString(expectedType) +
                            ", read 0x" + Integer.toHexString(type) + ".");
        }
    }

    public static final int[] readIntArray(InputStream stream, int elementCount) throws IOException {
        int[] result = new int[elementCount];
        for (int i = 0; i != elementCount; ++i) {
            result[i] = readInt(stream);
        }
        return result;
    }

    public static final int readInt(InputStream stream) throws IOException {
        return readInt(stream, 4);
    }

    public static final int readShort(InputStream stream) throws IOException {
        return readInt(stream, 2);
    }

    public static final String readString(InputStream stream) throws IOException {
        int length = readShort(stream);
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i != length; ++i) {
            builder.append((char) readShort(stream));
        }
        readShort(stream);
        return builder.toString();
    }

    public static final int readInt(InputStream stream, int length) throws IOException {
        int result = 0;
        for (int i = 0; i != length; ++i) {
            int b = stream.read();
            if (b == -1) {
                throw new EOFException();
            }
            result |= (b << (i * 8));
        }
        return result;
    }

}
