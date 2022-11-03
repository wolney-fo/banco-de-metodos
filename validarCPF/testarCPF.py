def testaCPF( cpf):
   
    soma = 0

    cpf = retiraCaracteresInvalidos(cpf);

    if len(cpf) != 11:
        return False

    if (allCharactersSame(cpf)):
        return False

    for i in range(1, 10):
        soma += int(cpf[i - 1]) * (11 - i)

    resto = (soma * 10) % 11

    if (resto == 10) or (resto == 11):
        resto = 0

    if (resto != int(cpf[9])):
        return False

    soma = 0

    for i in range(1, 11):
        soma += int(cpf[i - 1]) * (12 - i)

    resto = (soma * 10) % 11

    if (resto == 10) or (resto == 11):
        resto = 0

    if (resto != int(cpf[10])):
        return False

    return True


def retiraCaracteresInvalidos(string):
    string = string.replace(".", "")
    string = string.replace("-", "")
    string = string.replace(" ", "")
    return string


def allCharactersSame(string):
    for char in string:
        if (char == string[0]):
            return False
    return True
    