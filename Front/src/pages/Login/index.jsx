import { Link } from "react-router-dom";
import axios from 'axios'
import { useState } from "react";
import { LayoutComponents } from "../../components/LayoutComponents";

export const Login = () => {
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const [dados, setDados] = useState([]);

  const login = () => {
    axios
      .get('http://localhost:8080/usuario/search?email=' + email)
      .then((res) => {
        setDados(res)
        if (dados.status == 200) {
          localStorage.id = dados.data.id
          window.location.replace("lister")
        }
      })
  }

  return (
    <LayoutComponents>
      <div className="login-form">
        <span className="login-form-title">Login</span>

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

        <div className="container-login-form-btn">
          <button className="login-form-btn" onClick={login}>Login</button>
        </div>

        <div className="text-center">

          <span className="txt1">Não possui conta?</span>

          <Link to="/register" className="txt2">
            Criar conta
          </Link>

        </div>

      </div>
    </LayoutComponents>
  );
}