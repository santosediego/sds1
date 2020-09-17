import React from 'react'; //Todo arquivo react deve ter esse import;

type Props = {//Props são parametros
    message: string;
}

const Hello = ({message}: Props) => (
    <h1>Hello {message}</h1>
);

export default Hello;//Esse arquivo inteiro esta exportando esse componente;