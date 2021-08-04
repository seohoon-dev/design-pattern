package com.company.chain_of_responsibility;

import java.util.Scanner;

public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        // 객체 생성
        WithdrawChain withdraw100000Won = new Withdraw100000Won();
        WithdrawChain withdraw50000Won = new Withdraw50000Won();
        WithdrawChain withdraw10000Won = new Withdraw10000Won();
        WithdrawChain withdraw1000Won = new Withdraw1000Won();
        WithdrawChain withdraw100Won = new Withdraw100Won();

        // 체인 구성
        withdraw100000Won.setNextChain(withdraw50000Won);
        withdraw50000Won.setNextChain(withdraw10000Won);
        withdraw10000Won.setNextChain(withdraw1000Won);
        withdraw1000Won.setNextChain(withdraw100Won);

        while (true) {
            System.out.println("인출 할 돈을 눌러주세요");
            Scanner scanner = new Scanner(System.in);
            int money = scanner.nextInt();
            Currency currency = new Currency(money);
            withdraw100000Won.withdraw(currency);
            System.out.println("--------------");
        }

    }
}

interface WithdrawChain {
    void setNextChain(WithdrawChain withdrawChain);

    void withdraw(Currency currency);
}

class Currency {
    private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }

    public int getAmount() {
        return this.amount;
    }
}

class Withdraw100000Won implements WithdrawChain {
    private WithdrawChain withdrawChain;

    @Override
    public void setNextChain(WithdrawChain nextChain) {
        this.withdrawChain = nextChain;
    }

    @Override
    public void withdraw(Currency currency) {
        System.out.println("####10만원 인출기####");

        if (currency.getAmount() >= 100000) {
            int num = currency.getAmount() / 100000;
            int remain = currency.getAmount() % 100000;
            System.out.println("10만원짜리 " + num + "장이 인출되었습니다.");

            if (remain != 0) this.withdrawChain.withdraw(new Currency(remain));
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}

class Withdraw50000Won implements WithdrawChain {
    private WithdrawChain withdrawChain;

    @Override
    public void setNextChain(WithdrawChain nextChain) {
        this.withdrawChain = nextChain;
    }

    @Override
    public void withdraw(Currency currency) {
        System.out.println("####5만원 인출기####");

        if (currency.getAmount() >= 50000) {
            int num = currency.getAmount() / 50000;
            int remain = currency.getAmount() % 50000;
            System.out.println("5만원짜리 " + num + "장이 인출되었습니다.");

            if (remain != 0) this.withdrawChain.withdraw(new Currency(remain));
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}

class Withdraw10000Won implements WithdrawChain {
    private WithdrawChain withdrawChain;

    @Override
    public void setNextChain(WithdrawChain nextChain) {
        this.withdrawChain = nextChain;
    }

    @Override
    public void withdraw(Currency currency) {
        System.out.println("####1만원 인출기####");

        if (currency.getAmount() >= 10000) {
            int num = currency.getAmount() / 10000;
            int remain = currency.getAmount() % 10000;
            System.out.println("1만원짜리 " + num + "장이 인출되었습니다.");

            if (remain != 0) this.withdrawChain.withdraw(new Currency(remain));
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}

class Withdraw1000Won implements WithdrawChain {
    private WithdrawChain withdrawChain;

    @Override
    public void setNextChain(WithdrawChain nextChain) {
        this.withdrawChain = nextChain;
    }

    @Override
    public void withdraw(Currency currency) {
        System.out.println("####천원 인출기####");

        if (currency.getAmount() >= 1000) {
            int num = currency.getAmount() / 1000;
            int remain = currency.getAmount() % 1000;
            System.out.println("천원짜리 " + num + "장이 인출되었습니다.");

            if (remain != 0) this.withdrawChain.withdraw(new Currency(remain));
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}

class Withdraw100Won implements WithdrawChain {
    private WithdrawChain withdrawChain;

    @Override
    public void setNextChain(WithdrawChain nextChain) {
        this.withdrawChain = nextChain;
    }

    @Override
    public void withdraw(Currency currency) {
        System.out.println("####백원 인출기####");

        if (currency.getAmount() >= 100) {
            int num = currency.getAmount() / 100;
            int remain = currency.getAmount() % 100;
            System.out.println("백원짜리 " + num + "개가 인출되었습니다.");

            if (remain != 0) this.withdrawChain.withdraw(new Currency(remain));
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}

class Withdraw10Won implements WithdrawChain {
    private WithdrawChain withdrawChain;

    @Override
    public void setNextChain(WithdrawChain nextChain) {
        this.withdrawChain = nextChain;
    }

    @Override
    public void withdraw(Currency currency) {
        System.out.println("####십원 인출기####");
        System.out.println("withdrawChain = " + withdrawChain);

        if (currency.getAmount() >= 10) {
            int num = currency.getAmount() / 10;
            int remain = currency.getAmount() % 10;
            System.out.println("십원짜리 " + num + "개가 인출되었습니다.");

            if (remain != 0) this.withdrawChain.withdraw(new Currency(remain));
        } else {
            this.withdrawChain.withdraw(currency);
        }
    }
}