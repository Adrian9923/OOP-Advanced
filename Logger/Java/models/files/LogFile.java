package Java.models.files;

import Java.interfaces.File;

public class LogFile implements File {

    private StringBuilder builder;

    public LogFile() {
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String log){
        this.builder.append(log).append(System.lineSeparator());
    }

    @Override
    public long getSize() {
        String log = this.builder.toString();
        long size = 0;
        for (int i = 0; i < log.toCharArray().length; i++) {
            if (String.valueOf(log.charAt(i)).matches("[A-Za-z]")) {
                size += log.charAt(i);
            }
        }
        return size;

//        log = log.replaceAll("\\r+\\n+", "").replaceAll("\\W+", "");
//        log = log.replaceAll("\\d+", "");
//
//        return log.chars().mapToLong(ch -> ch).sum();
    }
}