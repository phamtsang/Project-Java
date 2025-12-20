'use client';

import { Card } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';

export function LoginForm() {
  return (
    <Card className="p-8">
      <form className="space-y-6">
        <div className="space-y-2">
          <Label htmlFor="username">Tên đăng nhập</Label>
          <Input id="username" placeholder="Nhập tên đăng nhập" />
        </div>
        <div className="space-y-2">
          <Label htmlFor="password">Mật khẩu</Label>
          <Input id="password" type="password" placeholder="Nhập mật khẩu" />
        </div>
        <Button type="submit" className="w-full">
          Đăng nhập
        </Button>
      </form>
    </Card>
  );
}
