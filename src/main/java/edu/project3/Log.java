package edu.project3;

import edu.project3.Models.HttpMethod;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Log(
    String remoteAddress,
    String remoteUser,
    OffsetDateTime timeLocal,
    HttpMethod method,
    String request,
    int status,
    String resource,
    long bodyBytesSent,
    String httpReferer,
    String httpUserAgent
) {
    private final static Pattern LOG_REGEX =
        Pattern.compile("(.+?) - (.+?) \\[(.+?)] \"(.+?)\" (\\d+) (\\d+) \"(.+?)\" \"(.+?)\"");

    @SuppressWarnings("checkstyle:MagicNumber")
    public static Log parse(String log) {
        Matcher matcher = LOG_REGEX.matcher(log);
        if (matcher.matches()) {
            String request = matcher.group(4);
            String[] requestSplit = request.split("\\s+");
            HttpMethod method = HttpMethod.valueOf(requestSplit[0]);
            String resource = requestSplit[1];

            return new Log(
                matcher.group(1),
                matcher.group(2),
                parseOffsetDate(matcher.group(3)),
                method,
                request,
                Integer.parseInt(matcher.group(5)),
                resource,
                Long.parseLong(matcher.group(6)),
                matcher.group(7),
                matcher.group(8)
            );
        } else {
            throw new IllegalArgumentException("Log does not match pattern");
        }

    }

    private static OffsetDateTime parseOffsetDate(String date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss ");
        DateTimeFormatter dateOffsetFormat = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(dateFormat)
            .appendOffset("+HHMM", "+0000")
            .toFormatter(Locale.ENGLISH);
        return OffsetDateTime.parse(date, dateOffsetFormat);
    }
}
