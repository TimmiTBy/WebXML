package com.epam.XMLweb.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SAX {
        {
            this.command = new ParseCommand("SAX");
        }
    },
    STAX {
        {
            this.command = new ParseCommand("STAX");
        }
    },
    DOM {
        {
            this.command = new ParseCommand("DOM");
        }
    };

    ICommand command;

    public ICommand getCurrentCommand() {
        return command;
    }
}
