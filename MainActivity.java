package com.fasttrade.app;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.content.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout root, content;
    TextView title;
    int blue=Color.rgb(23,105,255);

    @Override public void onCreate(Bundle b){ super.onCreate(b); showLogin(); }

    TextView tv(String s,int size){
        TextView t=new TextView(this); t.setText(s); t.setTextSize(size); t.setTextColor(Color.DKGRAY);
        t.setPadding(24,18,24,18); return t;
    }
    Button btn(String s){
        Button b=new Button(this); b.setText(s); b.setTextColor(Color.WHITE); b.setBackgroundColor(blue);
        b.setAllCaps(false); b.setPadding(18,10,18,10); return b;
    }
    void base(String heading){
        root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(20,24,20,20);
        root.setBackgroundColor(Color.WHITE); title=tv(heading,28); title.setTextColor(Color.BLACK); root.addView(title);
        content=new LinearLayout(this); content.setOrientation(LinearLayout.VERTICAL);
        ScrollView sc=new ScrollView(this); sc.addView(content); root.addView(sc,new LinearLayout.LayoutParams(-1,0,1));
        setContentView(root);
    }
    void showLogin(){
        base("FAST TRADE");
        content.addView(tv("Login to your account",20));
        EditText email=new EditText(this); email.setHint("Email"); content.addView(email);
        EditText pass=new EditText(this); pass.setHint("Password"); pass.setInputType(129); content.addView(pass);
        Button login=btn("Login"); content.addView(login);
        Button reg=btn("Create account"); content.addView(reg);
        login.setOnClickListener(v->showDashboard());
        reg.setOnClickListener(v->showRegister());
    }
    void showRegister(){
        base("Create account");
        EditText name=new EditText(this); name.setHint("Full name"); content.addView(name);
        EditText email=new EditText(this); email.setHint("Email"); content.addView(email);
        EditText phone=new EditText(this); phone.setHint("Phone number"); content.addView(phone);
        EditText pass=new EditText(this); pass.setHint("Password"); pass.setInputType(129); content.addView(pass);
        Button create=btn("Register"); content.addView(create);
        Button back=btn("Back to login"); content.addView(back);
        create.setOnClickListener(v->showDashboard());
        back.setOnClickListener(v->showLogin());
    }
    void showDashboard(){
        base("FAST TRADE Dashboard");
        content.addView(tv("Welcome 👋",22));
        content.addView(tv("Balance\nTSh 0 (demo)",24));
        Button dep=btn("💰 Deposit — TSh 20,000 to 500,000"); content.addView(dep);
        Button wallet=btn("👛 Wallet / Withdraw"); content.addView(wallet);
        Button ref=btn("👥 Referrals"); content.addView(ref);
        Button hist=btn("📋 Transaction History"); content.addView(hist);
        Button admin=btn("🛠 Admin Dashboard (demo)"); content.addView(admin);
        content.addView(tv("\nDemo mode: no real money is transferred. Returns are not guaranteed.",14));
        dep.setOnClickListener(v->showDeposit());
        wallet.setOnClickListener(v->showWallet());
        ref.setOnClickListener(v->showReferrals());
        hist.setOnClickListener(v->showHistory());
        admin.setOnClickListener(v->showAdmin());
    }
    void showDeposit(){
        base("Deposit");
        content.addView(tv("Enter amount (TSh 20,000–500,000)",18));
        EditText amount=new EditText(this); amount.setHint("e.g. 20000"); amount.setInputType(2); content.addView(amount);
        Button pay=btn("Continue to Payment (Demo)"); content.addView(pay);
        pay.setOnClickListener(v->{ new AlertDialog.Builder(this).setTitle("Demo payment").setMessage("Payment gateway is in sandbox/demo mode. No real payment was made.").setPositiveButton("OK",null).show(); });
    }
    void showWallet(){ base("Wallet"); content.addView(tv("Available balance\nTSh 0 (demo)",24)); content.addView(btn("Request Withdrawal (Demo)")); }
    void showReferrals(){ base("Referrals"); content.addView(tv("Your referral code: FT-DEMO123\nShare your code to invite users.",18)); }
    void showHistory(){ base("Transaction History"); content.addView(tv("No transactions yet.\nDemo transactions will appear here.",18)); }
    void showAdmin(){ base("Admin Dashboard"); content.addView(tv("Demo Admin\nUsers: 0\nPending transactions: 0",18)); content.addView(btn("Review transactions (demo)")); }
}
