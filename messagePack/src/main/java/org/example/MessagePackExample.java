package org.example;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.List;

// https://msgpack.org/
public class MessagePackExample {
    MessagePack mp = new MessagePack();

    public <T> byte[] write(T element) throws IOException {
        return mp.write(element);
    }

    public List<String> read(byte[] raw) throws IOException {
        return mp.read(raw, Templates.tList(Templates.TString));
    }
}
