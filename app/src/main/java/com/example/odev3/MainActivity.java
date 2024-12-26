package com.example.odev3;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.odev3.databinding.ActivityMainBinding;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public String islemler = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!islemler.isEmpty()){
                    if (islemler.charAt(islemler.length() -1) == ' ') {
                        islemler = islemler.substring(0, islemler.length() - 2);
                    }else {
                        islemler = islemler.substring(0, islemler.length() - 1);
                    }
                    binding.etSayiGiris.setText(islemler);

                    }
                }
        });
        binding.btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                islemler="";
                binding.etSayiGiris.setText("");
            }
        });

        binding.btnNokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noktaSorgulama()) {
                    islemler += ".";
                    binding.etSayiGiris.setText(islemler);
                }
            }

        });

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.isEmpty() || islemler.endsWith("+") || islemler.endsWith("-") || islemler.endsWith("x") || islemler.endsWith("/")){
                    islemler+= "0";
                } else if (islemler.equals("0")) {
                    islemler = "0";
                } else {
                    islemler += "0";
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="1";
                } else {
                    islemler = sifirDuzenleme(islemler, "1");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="2";
                } else {
                    islemler = sifirDuzenleme(islemler, "2");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="3";
                } else {
                    islemler = sifirDuzenleme(islemler, "3");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="4";
                } else {
                    islemler = sifirDuzenleme(islemler, "4");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="5";
                } else {
                    islemler = sifirDuzenleme(islemler, "5");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="6";
                } else {
                    islemler = sifirDuzenleme(islemler, "6");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="7";
                } else {
                    islemler = sifirDuzenleme(islemler, "7");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="8";
                } else {
                    islemler = sifirDuzenleme(islemler, "8");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islemler.equals("0")) {
                    islemler ="9";
                } else {
                    islemler = sifirDuzenleme(islemler, "9");
                }
                binding.etSayiGiris.setText(islemler);
            }
        });

        binding.btnArti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!OperatorSorgulama()){
                    if (OperatorUygunlugusorgulama()){
                        islemler +="+";
                        binding.etSayiGiris.setText(islemler);
                    }
                }
            }
        });

        binding.btnCarpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!OperatorSorgulama()){
                    if (OperatorUygunlugusorgulama()){
                        islemler +="x";
                        binding.etSayiGiris.setText(islemler);
                    }
                }
            }
        });

        binding.btnEksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!OperatorSorgulama()){
                    if (OperatorUygunlugusorgulama()){
                        islemler +="-";
                        binding.etSayiGiris.setText(islemler);
                    }
                }
            }
        });

        binding.btnBolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!OperatorSorgulama()){
                    if (OperatorUygunlugusorgulama()){
                        islemler +="/";
                        binding.etSayiGiris.setText(islemler);
                    }
                }
            }
        });

        binding.btnEsittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String giris = binding.etSayiGiris.getText().toString();

                if (giris.isEmpty()) {
                    binding.etSayiGiris.setText("Hata: Girdi Boş");
                    return;
                }
                giris = giris.replace('x', '*').replace('÷', '/');

                double sonuc = hesapla(giris);
                if (sonuc == (int) sonuc){
                    binding.etSayiGiris.setText(String.valueOf((int) sonuc));
                }else{
                    binding.etSayiGiris.setText(String.valueOf(sonuc));
                }
                islemler=binding.etSayiGiris.getText().toString();
            }
        });
    }

    // Nokta eklenebilir mi kontrol eder.
    private boolean noktaSorgulama() {
        if (islemler.isEmpty()) {
            return false;
        }

        char lastChar = islemler.charAt(islemler.length() -1);

        if (Character.isDigit(lastChar)) {
            String lastNumber = islemler.split( "[\\-+÷]")[islemler.split("÷\\-x÷]").length -1];
            return !lastNumber.contains(".");
        }

        return false;
    }



    private String sifirDuzenleme (String islemler, String yeniRakam) {
        if (islemler.matches(".*[+\\-x]0$")) {
            islemler = islemler.substring(0, islemler.length() -1)+ yeniRakam;
        } else {
            islemler += yeniRakam;
        }
        return islemler;
    }

    private boolean OperatorSorgulama() {
        if (islemler.isEmpty()) {
            return false;
        }
        char lastChar = islemler.charAt(islemler.length()-1); //Girisin son karakterini kontrol eder.
        return lastChar == '+' || lastChar == '-'|| lastChar == 'x' || lastChar == '÷'; // Eğer son karakter bir operatörse true döner.
    }
    // Operatör eklenebilir mi kontrol eder.
    private boolean OperatorUygunlugusorgulama() {
        if (islemler.isEmpty()) {
            return false;
        }
        char lastChar = islemler.charAt(islemler.length()-1); // bicisin son karakterini kontrol eder.
        return Character.isDigit(lastChar); // Eger son karakter cakamse, operatör eklenebilir.
    }

    private static int oncelik(char op){
        return (op == '+' || op == '-') ? 1: 2;
    }

    private static void hesaplaIslem(Stack<Integer> sayilar, char op){
        int b = sayilar.pop(), a = sayilar.pop();
        sayilar.push(op == '+' ? a + b : op == '-' ? a - b : op == '*' ? a*b : a/b);
    }

    public static int hesapla(String ifade){
        Stack<Integer> sayilar = new Stack<>();
        Stack<Character> operatorler = new Stack<>();

        for (int i = 0; i < ifade.length(); i ++){
            char c = ifade.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < ifade.length() && Character.isDigit(ifade.charAt(i))){
                    num = num * 10 + (ifade.charAt(i++) - '0');
                }
                sayilar.push(num);
                i--;
            } else if (c == '+' || c == '-' || c == '*' || c == '/' ) {
                while (!operatorler.isEmpty() && oncelik(operatorler.peek()) >= oncelik(c)){
                    hesaplaIslem(sayilar, operatorler.pop());
                }
                operatorler.push(c);
            }

        }
        while (!operatorler.isEmpty()){
            hesaplaIslem(sayilar, operatorler.pop());
        }
        return sayilar.pop();
    }
}

