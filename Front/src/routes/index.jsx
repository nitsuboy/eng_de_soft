import { BrowserRouter as Router, Routes, Route} from "react-router-dom"
import { Lister } from "../pages/Lister"
import { Login } from "../pages/Login"
import { Profile } from "../pages/Profile"
import { Register } from "../pages/Register"
import { Contract } from "../pages/Contract"

export const AppRouter = () => {
    return(
        <Router>
            <Routes>
                <Route path="/login" element={<Login/>} />
                <Route path="/register" element={<Register/>} />
                <Route path="/profile" element={<Profile/>} />
                <Route path="/lister" element={<Lister/>} />
                <Route path="/Contract" element={<Contract/>} />
            </Routes>
        </Router>

    )
}