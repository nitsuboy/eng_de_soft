
import { useState } from "react";
import { Link } from "react-router-dom";
import { LayoutComponents } from "../../components/LayoutComponents";


export const Register = () => {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [name, setName] = useState("")
    const [CPF, setCPF] = useState("")
    const [confirmation, setConfirmation] = useState("")
   
    return (
        <LayoutComponents>
            <form className="login-form">
                <span className="login-form-title">Criar conta</span>

                <div className="wrap-input">
                    <input className={name !== "" ? 'has-val input' : 'input'}
                        type="email" value={name} onChange={e => setName(e.target.value)} />
                    <span className="focus-input" data-placeholder="Nome"></span>
                </div>

                <div className="wrap-input">
                    <input className={email !== "" ? 'has-val input' : 'input'}
                        type="email" value={email} onChange={e => setEmail(e.target.value)} />
                    <span className="focus-input" data-placeholder="Email"></span>
                </div>

                <div className="wrap-input">
                    <input className={password !== "" ? 'has-val input' : 'input'}
                        type="password" value={password} onChange={e => setPassword(e.target.value)} />
                    <span className="focus-input" data-placeholder="Senha"></span>
                </div>

                <div className="wrap-input">
                    <input className={CPF !== "" ? 'has-val input' : 'input'}
                        type="password" value={CPF} onChange={e => setCPF(e.target.value)} />
                    <span className="focus-input" data-placeholder="CPF"></span>
                </div>

                <div className="confirmation">

                    <div className="tx5">
                        <input className="input-confirmation" checked type="radio" name="confirmation" value="cliente" onChange={e=>setConfirmation(e.target.value)} />
                        <span>Cliente</span>
                    </div>
                    
                    <div>
                        <input className="input-confirmation" type="radio" name="confirmation" value="prestador" onChange={e=>setConfirmation(e.target.value)} />
                        <span>Prestador de serviço</span>
                    </div>
                    
                </div>

                <div className="container-login-form-btn">
                    <button className="login-form-btn">Cadastrar</button>
                </div>

                <div className="text-center">
                    <span className="txt1">Já possui conta?</span>
                    
                    <Link to="/login" className="txt2">
                        Acessar com Email e Senha.
                    </Link>
                </div>

            </form>
        </LayoutComponents>
    );
}