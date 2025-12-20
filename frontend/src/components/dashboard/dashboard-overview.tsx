'use client';

import { Card } from '@/components/ui/card';

export function DashboardOverview() {
  return (
    <div className="space-y-6">
      <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-4">
        <Card className="p-6">
          <h3 className="text-sm font-medium text-muted-foreground">
            Doanh thu hôm nay
          </h3>
          <p className="mt-2 text-3xl font-bold">0 đ</p>
        </Card>
        <Card className="p-6">
          <h3 className="text-sm font-medium text-muted-foreground">
            Đơn hàng
          </h3>
          <p className="mt-2 text-3xl font-bold">0</p>
        </Card>
        <Card className="p-6">
          <h3 className="text-sm font-medium text-muted-foreground">
            Khách hàng
          </h3>
          <p className="mt-2 text-3xl font-bold">0</p>
        </Card>
        <Card className="p-6">
          <h3 className="text-sm font-medium text-muted-foreground">
            Công nợ
          </h3>
          <p className="mt-2 text-3xl font-bold">0 đ</p>
        </Card>
      </div>
      <Card className="p-6">
        <h3 className="text-lg font-semibold">Biểu đồ doanh thu</h3>
        <div className="mt-4 flex h-64 items-center justify-center text-muted-foreground">
          Đang phát triển...
        </div>
      </Card>
    </div>
  );
}
