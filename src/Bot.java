import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        switch (message.getText()) {
            case "/help": sendMsg(message,"Говори, глупец"); break;

        }
    }
    @Override
    public String getBotUsername() {
        return "FourHundredsIQbot";
    }
    @Override
    public String getBotToken() {
        return "655869433:AAF8j53t0vXsG8xCeXhSBSn0yRXwsHziVk0";
    }
    private void sendMsg(Message message, String text){
        SendMessage sm = new SendMessage();
        sm.setChatId(message.getChatId().toString());
        sm.setText(text);
        try {
            sendMessage(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
