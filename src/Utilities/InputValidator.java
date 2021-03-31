package Utilities;

public class InputValidator {
    private final int minNameSize = 3;
    private final int maxNameSize = 30;
    private final int minLastNameSize = 3;
    private final int maxLastNameSize = 20;
    private final int matriculaSize = 10;
    private final int minEmailSize = 10;
    private final int maxEmailSize = 40;
    private final int minPasswordSize = 8;
    private final int maxPasswordSize = 20;
    private final int phoneSize = 10;
    private final int nrcSize = 5;

    public boolean AreNamesValid( String name ) {
        return IsStringValidSize( name, minNameSize, maxNameSize ) && !HasInvalidCharacter( name ) &&
                !HasNumbers( name );
    }

    public boolean AreLastNamesValid( String lastNames ) {
        return IsStringValidSize( lastNames, minLastNameSize, maxLastNameSize ) && !HasInvalidCharacter( lastNames ) &&
                !HasNumbers( lastNames );
    }

    public boolean IsMatriculaValid( String matricula ) {
        return matricula.length() == matriculaSize && !HasSpaces( matricula ) && HasSingleZAndSChar( matricula ) &&
                HasNumbers( matricula ) && !HasInvalidCharacter( matricula );
    }

    public boolean IsTelephoneValid( String telephone ) {
        return telephone.length() == phoneSize && HasOnlyNumbers( telephone );
    }

    public boolean IsEmailValid( String email ) {
        return IsStringValidSize( email, minEmailSize, maxEmailSize ) && HasSingleAtChar( email ) &&
                !HasInvalidCharacter( email ) && !HasSpaces( email );
    }

    public boolean IsNRCValid( String nrc ) {
        return nrc.length() == nrcSize && HasOnlyNumbers( nrc );
    }

    public boolean IsPasswordValid( String password ) {
        return IsStringValidSize( password, minPasswordSize, maxPasswordSize ) && !HasInvalidCharacter( password ) &&
                !HasSpaces( password );
    }
    private boolean IsStringValidSize( String input, int minSize, int maxSize ) {
        return ( input.length() >= minSize && input.length() <= maxSize );
    }

    private boolean HasNumbers( String input ) {
        boolean hasNumbers = false;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( Character.isDigit( currentCharacter ) ) {
                hasNumbers = true;
            }
        }
        return hasNumbers;
    }

    private boolean HasSpaces( String input ) {
        boolean hasSpaces = false;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( currentCharacter == ' ' ) {
                hasSpaces = true;
            }
        }
        return hasSpaces;
    }

    private boolean HasSingleAtChar( String input ) {
        int atCounter = 0;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( currentCharacter == '@' ) {
                atCounter += 1;
            }
        }
        return atCounter == 1;
    }

    private boolean HasInvalidCharacter( String input ) {
        boolean hasInvalidCharacter = false;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( currentCharacter == '|' || currentCharacter == ';' ||
                currentCharacter == '=' || currentCharacter == 39 ) {
                hasInvalidCharacter = true;
            }
        }
        return hasInvalidCharacter;
    }

    private boolean HasSingleZAndSChar( String input ) {
        return input.contains( "zS" );
    }

    private boolean HasOnlyNumbers( String input ) {
        boolean hasOnlyNumbers = true;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( !Character.isDigit( currentCharacter ) ) {
                hasOnlyNumbers = false;
            }
        }
        return hasOnlyNumbers;
    }
}