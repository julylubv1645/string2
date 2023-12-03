package com.example.string2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String poem ="У лукоморья дуб зелёный;\n" +
            "Златая цепь на дубе том:\n" +
            "И днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\n" +
            "Идёт направо — песнь заводит,\n" +
            "Налево — сказку говорит.\n" +
            "Там чудеса: там леший бродит,\n" +
            "Русалка на ветвях сидит;\n" +
            "Там на неведомых дорожках\n" +
            "Следы невиданных зверей;\n" +
            "Избушка там на курьих ножках\n" +
            "Стоит без окон, без дверей;\n" +
            "Там лес и дол видений полны;\n" +
            "Там о заре прихлынут волны\n" +
            "На брег песчаный и пустой,\n" +
            "И тридцать витязей прекрасных\n" +
            "Чредой из вод выходят ясных,\n" +
            "И с ними дядька их морской;\n" +
            "Там королевич мимоходом\n" +
            "Пленяет грозного царя;\n" +
            "Там в облаках перед народом\n" +
            "Через леса, через моря\n" +
            "Колдун несёт богатыря;\n" +
            "В темнице там царевна тужит,\n" +
            "А бурый волк ей верно служит;\n" +
            "Там ступа с Бабою Ягой\n" +
            "Идёт, бредёт сама собой,\n" +
            "Там царь Кащей над златом чахнет;\n" +
            "Там русский дух… там Русью пахнет!\n" +
            "И там я был, и мёд я пил;\n" +
            "У моря видел дуб зелёный;\n" +
            "Под ним сидел, и кот учёный\n" +
            "Свои мне сказки говорил." ;

    private int numberOfCharacters;
    private int numberOfWords;

    private int numberOfCharactersL;
    private boolean wordFive;
    private String wordsCharactersA;
    private TextView infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = numberOfCharacters(poem);
        numberOfWords = numberOfWords(poem);
        numberOfCharactersL = numberOfCharactersL(poem);
        wordFive = wordFive(poem);
        wordsCharactersA = wordsCharactersA(poem);
        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Число символов в строке "+numberOfCharacters + "\n"
                +"Число слов в строке "+ numberOfWords+"\n"
                +"Число букв\"л\" в строке "+numberOfCharactersL+"\n"
                +"наличие слов \"из пяти букв\" "+wordFive +"\n"
                +"Строка из слов начинающихся на букву \"а\" "+wordsCharactersA);
    }
    private String wordsCharactersA(String stringPoem) {
        String stringM = "";
        String stPoem = stringPoem.replace( "\n",  " ").trim();
        String[] arrayPoem = stPoem.split( " ");
        for (String string : arrayPoem) {
            if (string.charAt(0) == 'а' | string.charAt(0) == 'А') {
                stringM += string + " ";
            }
        }
        return stringM.trim();
    }
    private boolean wordFive(String stringPoem) {
            String[] words = stringPoem.split(" ");
            for (String word : words) {
                if (word.length() == 5) {
                    return true;
                }
            }
            return false;
        }

    private int numberOfCharactersL(String stringPoem){
        String stPoem = stringPoem.trim();
        int count = 0;
        for (int i = 0; i < stPoem.length(); i++) {
            if (stPoem.charAt(i) == 'л') {
                count++;
            }
        }
        return count;
    }
    private int numberOfWords(String stringPoem){
        String stPoem = stringPoem.trim();
        int count = 0;
        for (int i = 0; i < stPoem.length(); i++) {
            if (stPoem.charAt(i) == ' '| stPoem.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }

    private int numberOfCharacters(String stringPoem){
        return stringPoem.length();
    }

}