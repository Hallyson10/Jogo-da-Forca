package API;

public enum Palavras {
	SASORI, ZETSU, KAKASHI, KILLER, GAARA, KABUTO, JIRAIYA, TSUNADE, OROCHIMARU, ITACHI, MINATO,
	OBITO, NAGATO, SASUKE, HASHIRAMA, HAMURA, MADARA, NARUTO, KAGUYA, HAGOROMO, HIDAN, KAKUZU, KONAN, TAKA,
	HAKU, AKAMARU, DEIARA, KISAME,AKATSUKI;

	public static Palavras getRandom() {
		return values()[(int) (Math.random() * values().length)];
	}
}
