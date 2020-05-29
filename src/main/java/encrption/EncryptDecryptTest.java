package main.java.encrption;

public final class EncryptDecryptTest {
    public static void main(String[] args) {

        String encryptedString = EncryptDecrypt.encryptWithSalt("ak_1MDE3MWJhMDg0ZjcwMDZkMTQ2MTVhMDM0MDAwMDAwMDA0171ba08504706d14615a034000000000zoNp8GQItDBEFH8zf33WS2IB4GAgctR", "ak_1MDE3MTUxNmZjM2MyMDZkMTQ2MTVhMDM0MDAwMDAwMDA0171ad37df88ee18ba36734b00000000V3QgIJx6Dvw1yWuWlcnYSO65pBK7OlAr");
//        String encryptedString = EncryptDecrypt.encryptWithSalt("ak_1MDE3MWJhMDg0ZjcwMDZkMTQ2MTVhMDM0MDAwMDAwMDA0171ba08504706d14615a034000000000zoNp8GQItDBEFH8zf33WS2IB4GAgctR", "ak_1MDE3MTUxNmZjM2MyMDZkMTQ2MTVhMDM0MDAwMDAwMDA0171ad37df88ee18ba36734b00000000V3QgIJx6Dvw1yWuWlcnYSO65pBK7OlAr");

        System.out.println(encryptedString);

        encryptedString = "[B@6168d5a0:Nz1VPTLNIWjef62VOttYwbW6aEGjbpXd2JXlIzwkEE2ht5yOd5uZ9UbhNne" +
                "+PayQxWRu7p7cdjHU4ErncAdc1TndykXaRK5JhXaCv1/F+QqdDbZC67LhvFc9sH5hv/bni9hvwPJJ27Rq4CrtLcRivQ==";

        System.out.println("DecryptedString:"+EncryptDecrypt.decryptWithSalt(encryptedString,"ak_1MDE2ZWM4OTlmNjUzYWU2MjgxZTgxOTMyMDAwMDAwMDA016eff1ce137925aab47482d00000000h13B3Xhpaf5eSDgURTbmKbnRHluLrZ6W"));

    }
}
