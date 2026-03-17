import React from 'react';
import { Link, useParams } from 'react-router-dom';
import Logo from '../../../components/utils/Logo';

const UserRegistrationVerification = () => {
    const { email } = useParams();

    return (
        <div className='container'>
            <div className="auth-form">
                <Logo />
                <h3 style={{ textAlign: 'center' }}>Verify Your Email</h3><br />
                <div className='msg' style={{ textAlign: 'center', fontWeight: 600 }}>
                    A verification link has been sent to <strong>{email}</strong>.<br /><br />
                    Please check your inbox and click the link to activate your account.
                </div>
                <br />
                <div className='msg'>
                    <Link to='/auth/login' className='inline-link'>Back to Login</Link>
                </div>
            </div>
        </div>
    );
};

export default UserRegistrationVerification;
