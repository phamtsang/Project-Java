import { LoginForm } from '@/components/auth/login-form';

export default function LoginPage() {
  return (
    <div className="flex min-h-screen items-center justify-center bg-gradient-to-br from-blue-50 to-indigo-100">
      <div className="w-full max-w-md">
        <div className="mb-8 text-center">
          <h1 className="text-4xl font-bold text-primary">BizFlow</h1>
          <p className="mt-2 text-gray-600">
            Nền tảng hỗ trợ chuyển đổi số cho doanh nghiệp
          </p>
        </div>
        <LoginForm />
      </div>
    </div>
  );
}
