package biscotte.kana;

/**
 * @param NONE
 * @author WATANABE Mamoru
 * @version Version 0.0  19 Feb.2000
 * @return NONE
 * @exception NONE
 * @see NONE
 **/
public class Kana {
  private String srcLine;
  private String cnvLine;

  /**
   * @param NONEaa
   * @return NONE
   * @throws NONE
   * @author WATANABE Mamoru
   * @version Version 0.0  19 Feb.2000
   * @see NONE
   **/
  public Kana() {
    srcLine = "";
  }

  /**
   * @param String x : �ϊ��O�̃��[�}��������
   * @return NONE
   * @throws NONE
   * @author WATANABE Mamoru
   * @version Version 0.0  19 Feb.2000
   * @see NONE
   **/
  public void setLine(String s) {
    srcLine = s; //s.toLowerCase();
  }

  /**
   * @param NONE
   * @return String : �ϊ���̂��ȕ�����
   * @throws NONE
   * @author WATANABE Mamoru
   * @version Version 0.0  19 Feb.2000
   * @see NONE
   **/
  public String getLine() {
    return cnvLine;
  }

  private String[][] r2kTable = {
    {"", "��", "��", "��", "��", "��"},             // 0.
    {"k", "��", "��", "��", "��", "��"},             // 1.
    {"s", "��", "��", "��", "��", "��"},             // 2.
    {"t", "��", "��", "��", "��", "��"},             // 3.
    {"n", "��", "��", "��", "��", "��"},             // 4.
    {"h", "��", "��", "��", "��", "��"},             // 5.
    {"m", "��", "��", "��", "��", "��"},             // 6.
    {"y", "��", "��", "��", "����", "��"},           // 7.
    {"r", "��", "��", "��", "��", "��"},             // 8.
    {"w", "��", "����", "��", "����", "��"},         // 9.

    {"g", "��", "��", "��", "��", "��"},             //10.
    {"z", "��", "��", "��", "��", "��"},             //11.
    {"j", "����", "��", "����", "����", "����"},     //12.
    {"d", "��", "��", "��", "��", "��"},             //13.
    {"b", "��", "��", "��", "��", "��"},             //14.
    {"p", "��", "��", "��", "��", "��"},             //15.
    {"gy", "����", "����", "����", "����", "����"},   //16.
    {"zy", "����", "����", "����", "����", "����"},   //17.
    {"jy", "����", "����", "����", "����", "����"},   //18.
    {"dy", "����", "����", "����", "����", "����"},   //19.
    {"by", "�т�", "�т�", "�т�", "�т�", "�т�"},   //20.
    {"py", "�҂�", "�҂�", "�҂�", "�҂�", "�҂�"},   //21.

    {"l", "��", "��", "��", "��", "��"},             //22.
    {"v", "����", "����", "��", "����", "����"},     //23.
    {"sh", "����", "��", "����", "����", "����"},     //24.
    {"sy", "����", "��", "����", "����", "����"},     //25.
    {"ch", "����", "��", "����", "����", "����"},     //26.
    {"cy", "����", "��", "����", "����", "����"},     //27.

    {"f", "�ӂ�", "�ӂ�", "��", "�ӂ�", "�ӂ�"},     //28.
    {"q", "����", "����", "��", "����", "����"},     //29.
    {"ky", "����", "����", "����", "����", "����"},   //30.
    {"ty", "����", "����", "����", "����", "����"},   //31.
    {"ny", "�ɂ�", "�ɂ�", "�ɂ�", "�ɂ�", "�ɂ�"},   //32.
    {"hy", "�Ђ�", "�Ђ�", "�Ђ�", "�Ђ�", "�Ђ�"},   //33.
    {"my", "�݂�", "�݂�", "�݂�", "�݂�", "�݂�"},   //34.
    {"ry", "���", "�股", "���", "�肥", "���"},   //35.
    {"ly", "��", "��", "��", "��", "��"},             //36.
    {"lt", "��", "��", "��", "��", "��"},             //37.
    {"xy", "��", "��", "��", "��", "��"},             //38.
    {"xt", "��", "��", "��", "��", "��"},             //39.
    {"x", "��", "��", "��", "��", "��"},             //40.
  };

  /**
   * @param String s : �q���̎��
   * @param int    n : �ꉹ�̎��
   * @return String : �ϊ���̂��ȕ�����(�ꉹ��)
   * @throws NONE
   * @author WATANABE Mamoru
   * @version Version 0.0  19 Feb.2000
   * @see NONE
   **/
  private String R2K(String s, int n) {

    if (n < 5) {
      for (int i = 0; i < 41; i++) {
        if (s.equals(r2kTable[i][0])) {
          return r2kTable[i][n + 1];
        }
      }
      return s + r2kTable[0][n + 1];
    } else if (n == 5) {
      return "��";
    } else {
      return "��";
    }
  }

  /**
   * @param NONE
   * @return NONE
   * @throws NONE
   * @author WATANABE Mamoru
   * @version Version 0.0  19 Feb.2000
   * @see NONE
   **/
  public void convert() {
    String buf;
    String tmp;

    cnvLine = "";
    buf = "";
    for (int i = 0; i < srcLine.length(); i++) {
      tmp = srcLine.substring(i, i + 1);

      if (tmp.equals("a")) {
        cnvLine = cnvLine + R2K(buf, 0);
        buf = "";
      } else if (tmp.equals("i")) {
        cnvLine = cnvLine + R2K(buf, 1);
        buf = "";
      } else if (tmp.equals("u")) {
        cnvLine = cnvLine + R2K(buf, 2);
        buf = "";
      } else if (tmp.equals("e")) {
        cnvLine = cnvLine + R2K(buf, 3);
        buf = "";
      } else if (tmp.equals("o")) {
        cnvLine = cnvLine + R2K(buf, 4);
        buf = "";
      } else {
        if (buf.equals("n")) {
          if (!(tmp.equals("y"))) {         /* "ny" */
            cnvLine = cnvLine + R2K(buf, 5);
            buf = "";
            if (tmp.equals("n")) continue; /* "nn" */
          }
        }

        if (java.lang.Character.isLetter(tmp.charAt(0))) {
          if (buf.equals(tmp)) {
            cnvLine = cnvLine + R2K(buf, 6);     /* "��" */
            buf = tmp;
          } else {
            buf = buf + tmp;
          }
        } else {
          cnvLine = cnvLine + buf + tmp;
          buf = "";
        }
      }

      //  System.out.println("buf,tmp:"+buf+","+tmp+","+cnvLine);
    }
    cnvLine = cnvLine + buf;
  }
}
