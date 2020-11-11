public class ServletsBasic {

    public static String startPage = "<form name=\"test\" method=\"post\" action=\"/login\">\n" +
            "    <h1>This is my first WebProgect</h1>\n" +
            "    <p><b>Enter login:</b><br>\n" +
            "        <input type=\"text\" name=\"login\" size=\"40\">\n" +
            "    </p>\n" +
            "    <p><b>Enter pass:</b><br>\n" +
            "        <input type=\"text\" name=\"pass\" size=\"40\">\n" +
            "    </p>\n" +
            "    <p><input type=\"submit\" value=\"Send\">\n" +
            "</form>\n" +
            "\n" +
            "<p><a href=\"/registration\">Registration</a></p>";
    public static String startPageIncorrectAnswer = "<form name=\"test\" method=\"post\" action=\"/login\">\n" +
            "    <div style=\"text-align: center;\">\n" +
            "        <h1>Incorrect login or password</h1>\n" +
            "        <h2>Please enter one more time</h2>\n" +
            "        <p><b>Enter login:</b><br>\n" +
            "            <input type=\"text\" name=\"login\" size=\"40\">\n" +
            "        </p>\n" +
            "        <p><b>Enter pass:</b><br>\n" +
            "            <input type=\"text\" name=\"pass\" size=\"40\">\n" +
            "        </p>\n" +
            "        <p><input type=\"submit\" value=\"Send\">\n" +
            "    </div>\n" +
            "</form>\n" +
            "\n" +
            "<div style=\"text-align: center;\">\n" +
            "    <p><a href=\"/registration\">Registration</a></p>\n" +
            "</div>";
    public static String registrationPage =
            "<form name=\"test\" method=\"post\" action=\"/\">\n" +
                    "    <div style=\"text-align: center;\">\n" +
                    "        <h1>Add your data, please</h1>\n" +
                    "\n" +
                    "        <p><b>Enter login:</b><br>\n" +
                    "            <input type=\"text\" name=\"login\" size=\"40\">\n" +
                    "        </p>\n" +
                    "        <p><b>Enter pass:</b><br>\n" +
                    "            <input type=\"text\" name=\"pass\" size=\"40\">\n" +
                    "        </p>\n" +
                    "        <p><b>Enter pass one more time:</b><br>\n" +
                    "            <input type=\"text\" name=\"passOne\" size=\"40\">\n" +
                    "        </p>\n" +
                    "        <p><b>Enter your name:</b><br>\n" +
                    "            <input type=\"text\" name=\"name\" size=\"40\">\n" +
                    "        </p>\n" +
                    "        <p><b>Enter your surname:</b><br>\n" +
                    "            <input type=\"text\" name=\"surname\" size=\"40\">\n" +
                    "        </p>\n" +
                    "        <p><input type=\"submit\" value=\"Send\">\n" +
                    "    </div>\n" +
                    "</form>\n" +
                    "<div style=\"text-align: center;\">\n" +
                    "    <p><a href=\"/\">back</a></p>\n" +
                    "</div>";
    public static String mainWindowPage = "<div style=\"text-align: center;\">\n" +
            "    <h1>You have successful entry</h1>\n" +
            "    <h2>Have a pleasure using our service :)</h2>\n" +
            "    <p><a href=\"/data\">Your personal account data</a></p>\n" +
            "    <p><a href=\"/\">Exit you account</a></p>\n" +
            "</div>";
}

