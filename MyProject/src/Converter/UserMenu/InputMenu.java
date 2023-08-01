package Converter.UserMenu;

import Converter.Exception.IncorrectNumberException;
public interface InputMenu {
    String getText();

    Integer getNumber() throws IncorrectNumberException;
}