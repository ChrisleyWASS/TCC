package br.com.mysthenrpg.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilDices {

	private Random random;

    public UtilDices() {
        this.random = new Random();
    }

    public int d20() {
        return random.nextInt(20) + 1;
    }
}

