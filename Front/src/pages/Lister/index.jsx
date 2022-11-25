import '../Lister/style.css'
import { FiUser, FiSearch } from 'react-icons/fi'
import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

export const Lister = () => {

    const [servicos, setServicos] = useState([]);
    useEffect(() => {
        getServicos();
    }, []);

    const getServicos = () => {
        axios
            .get('http://localhost:8080/servicos')
            .then((res) => setServicos(res.data))
    }

    const contract = (dados) => {
        localStorage.Sid = dados.id
        location.replace("contract")
    }

        return (
            <div className="containerMain">
                <div className="container">
                    <div className="top2">
                        <div className="top1">
                            <input type="text" placeholder='Exemplo' />
                            <button>
                                <FiSearch size={35} color='#24cffa' />
                            </button>
                        </div>

                        <div className="imageProfileBtn">
                            <button>
                                <Link to='/profile'>
                                    <FiUser size={35} color='#333333' />
                                </Link>
                            </button>
                        </div>
                    </div>

                    <div className="list">

                        {servicos.map((servico, key) => (
                            <div onClick={() =>contract(servico)} className="card" key={key}>
                                <div className="photo">
                                    <img src="data:image/png;base64,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" alt="" />
                                </div>
                                <div className="content">
                                    <h3>{servico.nome}</h3>
                                    <h3>{servico.descricao}</h3>
                                </div>
                                <div className="price">
                                    <h2>R${servico.preco}</h2>
                                </div>
                            </div>
                        ))}

                    </div>
                </div>
            </div>

        );
    }