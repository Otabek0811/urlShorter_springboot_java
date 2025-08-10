package uz.shortUrl.spring_boot_short_url.utils;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class TelegramAppender extends AppenderBase<LoggingEvent> {


    private static final String botToken = "6611216830:AAHbav2cJPZfl4ScJkuChd0xaJLFsK4XED0";
    private static final String chatId = "1072506938";

    private final TelegramBot tgBot = new TelegramBot(botToken);

    public TelegramAppender() {
        addFilter(new Filter<>() {
            @Override
            public FilterReply decide(LoggingEvent loggingEvent) {
                if (loggingEvent.getLevel().equals(Level.ERROR)) {
                    return FilterReply.ACCEPT;
                }
                return FilterReply.DENY;
            }
        });
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        SendMessage sendMessage = new SendMessage(chatId, loggingEvent.toString());
        sendMessage.parseMode(ParseMode.Markdown);
        tgBot.execute(sendMessage);

    }
}

